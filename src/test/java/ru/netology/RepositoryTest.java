package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Film film1 = new Film(1, "Бладшот", "Боевик");
    Film film2 = new Film(2, "Вперед", "Мультфильм");
    Film film3 = new Film(3, "Отель 'Белград'", "Комедия");

    @Test
    public void shouldFindAllInEmptyRepository() {
        Repository repo = new Repository();
        Film[] expected = {};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllInNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        Film[] expected = {film1, film2, film3};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdInEmptyRepository() {
        Repository repo = new Repository();
        Film actual = repo.findById(3);
        assertNull(actual);
    }

    @Test
    public void shouldFindByIdInNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        Film actual = repo.findById(3);
        assertNull(actual);
    }

    @Test
    public void shouldFindById() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        Film expected = film3;
        Film actual = repo.findById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdInEmptyRepository() {
        Repository repo = new Repository();
        repo.removeByID(3);
        Film[] expected = {};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdInNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        repo.removeByID(3);
        Film[] expected = {film1, film2};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.removeByID(2);
        Film[] expected = {film1, film3};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllInEmptyRepository() {
        Repository repo = new Repository();
        repo.removeAll();
        Film[] expected = {};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.removeAll();
        Film[] expected = {};
        Film[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}