package ru.job4j.condition;

/**
 * Максимальное число
 */
public class Max {
    /**
     * @param left  первое число
     * @param right второе число
     * @return максимальное число
     */
    public int max(int left, int right) {
        return (left > right) ? left : right;
    }

    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

    public int max(int first, int second, int third, int fourth) {
        return max(max(first, second, third), fourth);
    }
}
