package ru.netology;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManagerTest {
    Film film1 = new Film(1, "Бладшот", "Боевик");
    Film film2 = new Film(2, "Вперед", "Мультфильм");
    Film film3 = new Film(3, "Отель 'Белград'", "Комедия");
    Film film4 = new Film(4, "Джентельмены", "Боевик");
    Film film5 = new Film(5, "Человек-невидимка", "Ужасы");

    @Test
    public void shouldCreateManagerWithDefaultLastCount() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        int expected = 10;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateManagerWithDefaultLastCountWhenNegative() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo, -5);
        int expected = 10;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateManagerWithDefaultLastCountWhenEqualZero() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo, 0);
        int expected = 10;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateManagerWithDefaultLastCountWhenValid() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo, 1);
        int expected = 1;
        int actual = manager.getLastCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIntoEmptyRepository() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(film1);
        Film[] expected = {film1};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddIntoNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        Manager manager = new Manager(repo);
        manager.add(film4);
        Film[] expected = {film1, film2, film3, film4};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMocked() {
        Repository repo = Mockito.mock(Repository.class);
        Film[] films = {film1, film2, film3};
        doReturn(films).when(repo).findAll();
        Manager manager = new Manager(repo);
        Film[] expected = {film1, film2, film3};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenLessThanLimitMocked() {
        Repository repo = Mockito.mock(Repository.class);
        Film[] films = {film1, film2, film3, film4, film5};
        doReturn(films).when(repo).findAll();
        Manager manager = new Manager(repo, 10);
        Film[] expected = {film5, film4, film3, film2, film1};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoreLessThanLimitMocked() {
        Repository repo = Mockito.mock(Repository.class);
        Film[] films = {film1, film2, film3, film4, film5};
        doReturn(films).when(repo).findAll();
        Manager manager = new Manager(repo, 3);
        Film[] expected = {film5, film4, film3};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}