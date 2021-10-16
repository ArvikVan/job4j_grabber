package ood.lsp.precondition;


/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 */
public class Bus extends AutoTransport {
    public Bus(float fuel) {
        super(fuel);
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 5) {
            throw new IllegalArgumentException("Need more fuel");
        }
    }
}
