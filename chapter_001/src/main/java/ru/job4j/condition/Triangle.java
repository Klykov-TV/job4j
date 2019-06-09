package ru.job4j.condition;

public class Triangle {

    /**
     * Полупериметр треугольника
     *
     * @param a первая сторона
     * @param b вторая сторона
     * @param c третья сторона
     * @return Полупериметр
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
     * @param x1 х координата 1 точки
     * @param x2 х координата 2 точки
     * @param x3 х координата 3 точки
     * @param y1 у координата 1 точки
     * @param y2 у координата 2 точки
     * @param y3 у координата 3 точки
     * @return Площадь треугольника, если он существует, или -1.
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl = -1;
        Point one = new Point(x1, y1);
        Point two = new Point(x2, y2);
        Point three = new Point(x3, y3);
        double a = one.distance(two);
        double b = two.distance(three);
        double c = three.distance(one);
        double p = period(a, b, c);

        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        return rsl;
    }
}
