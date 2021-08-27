import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriggerTest {

    @Test
    public void test() {
        Assert.assertEquals(1, new Trigger().someLogic());
    }

}