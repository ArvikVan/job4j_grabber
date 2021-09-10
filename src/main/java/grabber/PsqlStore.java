package grabber;
/**
 * класс описывает работу с бд (добавление, поиск по id, просмотр всего списка)
 * @author arvikv
 * @version 1.0
 */

import html.SqlRuParse;
import utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {
    private final Connection cnn;

    /**
     * метод описывает поиск файла с настройками, его чтение и соединение с бд
     * @param cfg на входе свойства по которым войдем с бд
     * @throws SQLException исключения ловим
     */
    public PsqlStore(Properties cfg) throws SQLException {
        try (InputStream in = PsqlStore.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Ошибка в методе PsqlStore"); e.printStackTrace();
        }
        cnn = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password")
        );
    }

    /**
     * метод описывает сохранение в бд поста
     * @param post на входе пост(модель данных)
     *             не забываем про таблицу в бд, есть уникальное поле которое не позволяет
     *             добавлять посты с одинаковыми ссылками
     */
    @Override
    public void save(Post post) {
        try (PreparedStatement preparedStatement = cnn.prepareStatement(
                "insert into post(name, text, link, created) values (?, ?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, post.getTitle());
                preparedStatement.setString(2, post.getDescription());
                preparedStatement.setString(3, post.getLink());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
                preparedStatement.execute();
            try (ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    post.setId(generatedKey.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе save(Post post)"); throwables.printStackTrace();
        }
    }

    /**
     * метод описывает получение всей таблицы, по запросу
     * @return на выходе список всех постов, всей таблицы
     */
    @Override
    public List<Post> getAll() {
        List<Post> list = new ArrayList<>();
        try (PreparedStatement prGetAll = cnn.prepareStatement(
                "select * from post"
        )) {
            try (ResultSet resultSet = prGetAll.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Post(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("text"),
                            resultSet.getString("link"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }

        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе getAll()"); throwables.printStackTrace();
        }
        return list;
    }

    /**
     * метод описывает поиск по id
     * @param id на входе id по которому будем искать
     * @return на выходе найденный пост
     */
    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement prFindById = cnn.prepareStatement(
                "select * from post where id = ?"
        )) {
            prFindById.setInt(1, id);
            try (ResultSet resultSet = prFindById.executeQuery()) {
                if (resultSet.next()) {
                    post = new Post(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("text"),
                            resultSet.getString("link"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе findById(int id)"); throwables.printStackTrace();
        }
        return post;
    }

    public static void main(String[] args) throws SQLException, IOException {
            SqlRuParse sqlRuParse = new SqlRuParse(new SqlRuDateTimeParser());
            Post post = sqlRuParse.detail("https://www.sql.ru/forum/1338405/vakansiya-sistemnyy-analitik");
            Properties properties = new Properties();
            PsqlStore psqlStore = new PsqlStore(properties);
            psqlStore.save(post);
            System.out.println(psqlStore.findById(1));
            System.out.println(psqlStore.getAll());

    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }
}
