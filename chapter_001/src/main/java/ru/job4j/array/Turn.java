package ru.job4j.array;

/**
 * Переворачивает массив
 */
public class Turn {
    /**
     * Переворачивает массив
     *
     * @param array оригинальный массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        int j = array.length;
        for (int i = 0; i < j / 2; i++) {
            int swap = array[i];
            array[i] = array[j - i - 1];
            array[j - i - 1] = swap;
        }
        return array;
    }
}
