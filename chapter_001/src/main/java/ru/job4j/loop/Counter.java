package ru.job4j.loop;

/**
 * Вычисление суммы четных чисел в произвольном диапазоне
 * @author Timofey Klykov
 * @since 25.05.2019
 */
public class Counter {
    /**
     * @param start первое значение в диапазоне
     * @param finish последнее значение в диапазоне
     * @return сумма четных чисел в произвольном диапазоне
     */
    public int add(int start, int finish){
        int sum = 0;
        while(start <= finish){
            if(start%2==0) {
                sum += start;
                }
            start++;
            }
        return sum;
        }
    }
