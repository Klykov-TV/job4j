package ru.job4j.condition;

public class Triangle {

    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * @param a первая сторона
     * @param b вторая сторона
     * @param c третья сторона
     * @return Полупериметр треугольника
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * @param a первая сторона
     * @param b вторая сторона
     * @param c третья сторона
     * @return Возможность существования
     */
    private boolean exist(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /**
     * @return Площадь треугольника, если он существует, или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);

        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        return rsl;
    }
}
