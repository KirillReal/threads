package ru.job4j;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CountTest extends TestCase {
    /**
     * Класс описывает нить со счетчиком.
     */
    private static class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.increment();
        }
    }

    public void testIncrement() throws InterruptedException {
        /* Создаем счетчик. */
        final Count count = new Count();
        /* Создаем нити. */
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        /* Запускаем нити. */
        first.start();
        second.start();
        /* Заставляем главную нить дождаться выполнения наших нитей. */
        first.join();
        second.join();
        /* Проверяем результат. */
        assertThat(count.get(), is(2));
    }
}