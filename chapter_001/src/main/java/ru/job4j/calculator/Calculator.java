package ru.job4j.calculator;

/**
 * Калькулятор из 4 арифметических операций
 */
public class Calculator {

    /**
     * @param first первое значение
     * @param second второе значение
     * @return Сумму
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * @param first первое значение
     * @param second второе значение
     * @return Разность
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * @param first первое значение
     * @param second второе значение
     * @return Частное
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * @param first первое значение
     * @param second второе значение
     * @return Произведение
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}