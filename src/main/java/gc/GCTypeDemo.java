package gc;

/**
 * класс показывает работу с разными сборщиками
 * @author arvikv
 * @version 1.0
 * Edit Configuration://
 * - Serial => -XX:+UseSerialGC
 * - Parallel => -XX:+UseParallelGC
 * - CMS => -XX:+UseConcMarkSweepGC (допуступен до JDK 14)
 * - G1 => -XX:+UseG1GC
 * - ZGC => -XX:+UseZGC (use together, because error) -XX:+UnlockExperimentalVMOptions
 * logs: -Xlog:gc* or -XX:-PrintGCDetails if jdk < 9
 */

import java.util.Random;

public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (int i = 0;; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)).repeat(length);
        }
    }
}
