package ru.job4j.array;

/**
 * Проверяет, что массив состоит из одинаковых значений
 *
 * @author Timofey Klykov
 * @since 28.05.2019
 */

public class Check {
    /**
     * @param data Входящий массив
     * @return результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
