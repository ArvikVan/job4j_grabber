package template;

import java.util.Map;

/**
 * Интерфейс описывающий решение
 * @author arvikv
 * @version 1.0
 * @since 10.10.2021
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}
