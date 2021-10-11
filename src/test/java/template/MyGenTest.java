package template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author arvikv
 * @version 1.0
 * @since 10.10.2021
 */
public class MyGenTest {
    @Ignore
    @Test
    public void test1() {
        MyGen myGen = new MyGen();
        String produce = myGen.produce("I am a ${name}, Who are ${subject}? ",
                new HashMap<>(Map.of("name", "Arviy Khubetsov", "subject", "you")));
        assertThat(produce, is("I am a Arviy Khubetsov, Who are you?"));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenManyKeys() {
        MyGen myGen = new MyGen();
        String produce = myGen.produce("I am a ${name}, Who are ${subject}? ",
                new HashMap<>(Map.of(
                        "name", "Arviy Khubetsov",
                        "subject", "you",
                        "dateOfBirth", "31-05-1981"
                )));
        assertEquals(produce, "I am a Arviy Khubetsov, Who are you?");
    }
}