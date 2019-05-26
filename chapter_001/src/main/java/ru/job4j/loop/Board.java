package ru.job4j.loop;

/**
 * Класс рисует шахматную доску из х и проблеов.
 *
 * @author Timofey Klykov
 * @since 26.05.2019
 */
public class Board {
    /**
     * @param width  ширина шахматной доски
     * @param height высота шахматной доски
     * @return шахматная доска
     */
    public String paint(int width, int height) {
        String ln = System.lineSeparator();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((j + i) % 2 == 0) {
                    str.append("x");
                } else {
                    str.append(" ");
                }
            }
            str.append(ln);
        }
        return str.toString();
    }
}
