package ru.job4j.array;


import java.util.Arrays;

/**
 * Удаление дубликатов из массива
 */
public class ArrayDuplicate {
    /**
     * @param array исходный массив
     * @return массив после удаления дубликатов
     */
    public String[] remove(String[] array) {
        int n = array.length;
        for (int i = 0; i <= n - 1; i++) {
            String ex = array[i];
            for (int j = i + 1; j <= n - 1; j++) {
                if (array[j].equals(ex)) {
                    for (int z = j; z < n - 1; z++) {
                        String tmp = array[z];
                        array[z] = array[z + 1];
                        array[z + 1] = tmp;
                    }
                    n--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, n);
    }
}