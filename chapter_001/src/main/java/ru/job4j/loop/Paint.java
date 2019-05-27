package ru.job4j.loop;

/**
 * Класс рисует пирамиду в псевдографике
 *
 * @author Timofey Klykov
 * @since 27.06.2019
 */
public class Paint {
    /**
     * @param height высота пирамиды
     * @return возвращает пирамиду в виде строки
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
