package ru.job4j.array;

/**
 * Класс заполняет массив квадратом числе от 1 до bound
 * @author Timofey Klykov
 * @since 28.05.2019
 */
public class Square {
    /**
     * @param bound количество чисел массива
     * @return массив из квадратов чисел от 1 до bound
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= rst.length; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
