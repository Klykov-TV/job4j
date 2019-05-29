package ru.job4j.array;

/**
 * Создает двухмерный массив, представляющий таблицу умножения
 *
 * @author Timofey Klykov
 * @since 29.05.2019
 */
public class Matrix {
    /**
     * @param size размер двухмерного массива
     * @return таблицу умножения
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
