package ru.job4j.array;

/**
 * Проверяет, начинается ли слово с определенной последовательности символов
 *
 * @author Timofey Klykov
 * @since 29.05.2019
 */

public class ArrayChar {
    /**
     * @param word   проверяемое слово
     * @param prefix предполгаемая начальная последовательность
     * @return результат проверки
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length - 1; i++) {
            if (pref[i] != wrd[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

}
