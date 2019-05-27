package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Класс рисует пирамиду в псевдографике
 *
 * @author Timofey Klykov
 * @since 27.06.2019
 */
public class Paint {
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * @param height высота пирамиды
     * @return возвращает пирамиду в виде строки
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
}
