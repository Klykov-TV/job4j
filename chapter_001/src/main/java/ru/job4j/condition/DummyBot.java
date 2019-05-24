package ru.job4j.condition;

/**
 * Глупый бот
 */
public class DummyBot {
    /**
     * Ответ на вопрос
     *
     * @param question вопрос
     * @return ответ на вопрос
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи!";
        }
        return rsl;
    }
}
