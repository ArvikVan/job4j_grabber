package grabber;
/**
 * @author arvikv
 * @version 1.0
 */

import java.io.IOException;
import java.util.List;

public interface Parse {

    List<Post> list(String link) throws IOException;

    Post detail(String link) throws IOException;
}
