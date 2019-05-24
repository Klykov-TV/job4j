package ru.job4j.condition;

/**
 * Вычисление максимального числа из 3
 */
public class MultiMax {

    /**
     * @param first  первое число
     * @param second второе число
     * @param third  третье число
     * @return максимальное из 3
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        result = result > third ? result : third;
        return result;
    }
}
