package ood.isp;

/**
 * Первый пример нарушения принципа InterfaceSegregationPrinciple
 * @author arvikv
 * @version 1.0
 * @since 20.10.2021
 */
public interface Car {
    boolean abs();
    void engine();
    void transmission();
    void autoSound();
    void ruleHeater();
    void condition();
}
