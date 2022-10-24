package ru.netology;

public class Repository {
    private Film[] films = new Film[0];

    public Film[] findAll() {
        return films;
    }

    public void save(Film film) {
        Film[] tmp = new Film[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public Film findById(int id) {
        for (Film film : films) {
            if (film.id == id) {
                return film;
            }
        }
        return null;
    }

    public void removeByID(int id) {
        if (findById(id) == null) {
            return;
        }
        int copyToIndex = 0;
        Film[] tmp = new Film[films.length - 1];
        for (int i = 0; i < films.length; i++) {
            if (films[i].id != id) {
                tmp[copyToIndex] = films[i];
                copyToIndex++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new Film[0];
    }
}