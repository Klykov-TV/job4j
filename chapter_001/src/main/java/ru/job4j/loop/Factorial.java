package ru.job4j.loop;

/**
 * Вычисление факториала числа
 *
 * @author Timofey Klykov
 * @since 26.05.2019
 */
public class Factorial {
    /**
     * @param n число, для которого хотим вычислить факториал
     * @return факториал числа
     */
    public int calc(int n) {
        int fact = 1;
        while (n > 1) {
            fact *= n;
            n--;
        }
        return fact;
    }
}
