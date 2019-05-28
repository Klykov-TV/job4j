package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == data[i + 1]) {
                count++;
            }
        }
        if (count == data.length - 1) {
            result = true;
        }
        return result;
    }
}
