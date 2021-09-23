package gc;
/**
 *
 * @author arvikv
 * @version 1.1
 * Edit Configurations -Xmx4m -Xms4m
 * Edit Configuration -Xmx4m -Xms2m
 */
public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();
    
    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("==== Environment state ==== ");
        System.out.printf("Free: %d%n", freeMemory);
        System.out.printf("Total: %d%n", totalMemory);
        System.out.printf("Max: %d%n", maxMemory);
    }
    
    public static void main(String[] args) {
        System.out.println("Size before creation");
        info();

        for (int i = 0; i < 100; i++) {
            new UserGC(i, "1");
        }
        System.out.println("Size after creation");
        info();
        System.gc();
        System.out.println("Size after GC");
        info();
    }
    
}
