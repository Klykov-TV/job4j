package ru.job4j.array;

/**
 * Класс ищет элемент в массиве
 * @author Timofey Klykov
 * @since 28.05.2019
 */
public class FindLoop {
    /**
     * @param data Массив, в котором ищем элемент
     * @param el   Искомый элемент
     * @return Индекс искомого элемента или -1 в случае отсутствия элемента
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
