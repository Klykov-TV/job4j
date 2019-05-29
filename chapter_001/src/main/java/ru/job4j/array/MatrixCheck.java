package ru.job4j.array;

/**
 * Проверяет, что все элементы каждой диагонали квадратного двумерного макссива равны
 *
 * @author Timofey Klykov
 * @since 30.05.2019
 */
public class MatrixCheck {
    /**
     * @param data входящий массив
     * @return результат проверки
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int j = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][j - i] != data[i + 1][j - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

