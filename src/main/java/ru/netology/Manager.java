package ru.netology;

public class Manager {
    private Film[] films = new Film[0];
    private int lastCount = 10;

    public Manager () {

    }

    public Manager(int lastCount) {
        if (lastCount > 0) {
            this.lastCount = lastCount;
        }
    }

    public int getLastCount() {
        return lastCount;
    }

    public void save(Film item) {
        Film[] tmp = new Film[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = item;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultCount = films.length <= lastCount ? films.length : lastCount;
        Film[] tmp = new Film[resultCount];
        for (int i = 0; i < resultCount; i++) {
            tmp[i] = films[films.length - 1 - i];
        }
        return tmp;
    }
}