package ru.job4j.conventer;

/**
 * Конвентер валюты
 */
public class Conventer {
    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / 70);
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары.
     */
    public int rubleToUSD(int value) {
        return (value / 60);
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return (value * 70);
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return рубли.
     */
    public int usdToRuble(int value) {
        return (value * 60);
    }
}
