package kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author arvikv
 * @version 1.0
 * @since 08.10.2021
 */
public class MaxMinTest {

    @Test
    public void max() {
        MaxMin max = new MaxMin();
        List<Integer> list = List.of(1, 12, 4, 6, 52, 540);
        Comparator<Integer> comparator = Integer::compareTo;
        int result = max.max(list, comparator);
        assertThat(result, is(540));
    }

    @Test
    public void min() {
        MaxMin min = new MaxMin();
        List<Integer> list = List.of(54, 45, 1, 5);
        Comparator<Integer> comparator = Integer::compareTo;
        int result = min.min(list, comparator);
        assertThat(result, is(1));
    }

}