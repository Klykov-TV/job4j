package ru.job4j.condition;

/**
 * Вычисляет площадь прямоугольника
 */
public class SqArea {
    /**
     * @param p периметр
     * @param k w=kh
     * @return площадь
     */
    public int square(int p, int k) {
        int h = p / (2 * k + 2);
        int w = (p - 2 * h) / 2;
        return h * w;
    }
}
