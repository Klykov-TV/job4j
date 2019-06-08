package ru.job4j.task001;

/**
 * Класс объединяет 2 отсортированных массива в 1.
 *
 * @author Timofey Klykov
 * @since 06.06.2019
 */
public class Task001 {
    /**
     * @param first  первый массив
     * @param second второй массив
     * @return массив, созданный в результате объединения первых двух.
     */
    public int[] combined(int[] first, int[] second) {
        int x = first.length + second.length;
        int[] result = new int[x];
        int i = 0;
        int j = 0;
        for (int z = 0; z < x; z++) {
            if (i < first.length && j < second.length) {
                if (first[i] < second[j]) {
                    result[z] = first[i];
                    i++;
                } else {
                    result[z] = second[j];
                    j++;
                }
            } else if (i < first.length) {
                result[z] = first[i];
                i++;
            } else {
                result[z] = second[j];
                j++;
            }
        }
        return result;
    }

}
