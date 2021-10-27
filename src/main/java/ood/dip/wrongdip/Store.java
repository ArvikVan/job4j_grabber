package ood.dip.wrongdip;

import java.util.HashMap;

/**
 * Класс хранилище, нарушаем принцип DIP, т.к. такие вещи надо выносить в
 * интерфейс и реализовывать отдельно
 * @author arvikv
 * @version 1.0
 * @since 27.10.2021
 * У сервиса есть единственное поле - мапа, для хранения данных. С точки зрения DIP,
 * это нарушение, потому что мы зависим от реализации, а не абстракции.
 * Решение - выделение абстракции для хранилища и уже далее от него нужно
 * будет реализовать InMemoryShopStore
 */
public class Store<K, V> {
    private HashMap<K, V> mapForStorage = new HashMap<>();
}
