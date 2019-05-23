package ru.job4j.conventer;

/**
 * Конвентер валюты
 */
public class Conventer {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / 70);
    }

    public int rubleToUSD(int value) {
        return (value / 60);
    }

    public int euroToRuble(int value) {
        return (value * 70);
    }

    public int usdToRuble(int value) {
        return (value * 60);
    }
}
