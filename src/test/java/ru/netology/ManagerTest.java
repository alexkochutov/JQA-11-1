package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Film film1 = new Film(1, "Бладшот", "Боевик");
    Film film2 = new Film(2, "Вперед", "Мультфильм");
    Film film3 = new Film(3, "Отель 'Белград'", "Комедия");
    Film film4 = new Film(4, "Джентельмены", "Боевик");
    Film film5 = new Film(5, "Человек-невидимка", "Ужасы");
    Film film6 = new Film(6, "Тролли. Мировой тур", "Мультфильм");
    Film film7 = new Film(7, "Номер один", "Комедия");
    Film film8 = new Film(8, "Интерсталлар", "Фантастика");
    Film film9 = new Film(9, "Пассажиры", "Фантастика");
    Film film10 = new Film(10, "Человек, который изменил все", "Драма");
    Film film11 = new Film(11, "Джанго освобожденный", "Боевик");
    Film film12 = new Film(12, "Душа", "Мультфильм");
    Film film13 = new Film(13, "Рататуй", "Мультфильм");
    Film film14 = new Film(14, "Марсианин", "Фантастика");
    Film film15 = new Film(15, "Игры разума", "Драма");

    @Test
    public void shouldCreateManagerWithDefaultLastCount() {
        Manager manager = new Manager();
        int expected = 10;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateManagerWithDefaultLastCountWhenNegative() {
        Manager manager = new Manager(-5);
        int expected = 10;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateManagerWithDefaultLastCountWhenEqualZero() {
        Manager manager = new Manager(0);
        int expected = 10;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateManagerWithDefaultLastCountWhenValid() {
        Manager manager = new Manager(1);
        int expected = 1;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveInEmptyArray() {
        Manager manager = new Manager();
        manager.save(film1);
        Film[] expected = {film1};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveInNotEmptyArray() {
        Manager manager = new Manager();
        manager.save(film1);
        manager.save(film2);
        Film[] expected = {film1, film2};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllNothingWhenArrayIsEmpty() {
        Manager manager = new Manager();
        Film[] expected = {};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllWhenArrayIsNotEmpty() {
        Manager manager = new Manager();
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
        manager.save(film7);
        manager.save(film8);
        manager.save(film9);
        manager.save(film10);
        manager.save(film11);
        manager.save(film12);
        manager.save(film13);
        manager.save(film14);
        manager.save(film15);
        Film[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12, film13, film14, film15};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNothingWithDefaultLastCount() {
        Manager manager = new Manager();
        Film[] expected = {};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnWhenArrayLessThenDefaultLastCount() {
        Manager manager = new Manager();
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        Film[] expected = {film5, film4, film3, film2, film1};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnWhenArrayMoreThenDefaultLastCount() {
        Manager manager = new Manager();
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
        manager.save(film7);
        manager.save(film8);
        manager.save(film9);
        manager.save(film10);
        manager.save(film11);
        manager.save(film12);
        manager.save(film13);
        manager.save(film14);
        manager.save(film15);
        Film[] expected = {film15, film14, film13, film12, film11, film10, film9, film8, film7, film6};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNothingWithCustomLastCount() {
        Manager manager = new Manager(5);
        Film[] expected = {};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnWhenArrayLessThenCustomLastCount() {
        Manager manager = new Manager(5);
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        Film[] expected = {film3, film2, film1};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnWhenArrayMoreThenCustomLastCount() {
        Manager manager = new Manager(5);
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
        manager.save(film7);
        manager.save(film8);
        manager.save(film9);
        manager.save(film10);
        Film[] expected = {film10, film9, film8, film7, film6};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}