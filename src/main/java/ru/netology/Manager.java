package ru.netology;

public class Manager {
    Repository repo = new Repository();
    private int lastCount = 10;

    public Manager (Repository repo) {
        this.repo = repo;
    }

    public Manager (Repository repo, int lastCount) {
        this.repo = repo;
        if (lastCount > 0) {
            this.lastCount = lastCount;
        }
    }

    public int getLastCount() {
        return lastCount;
    }

    public void add(Film item) {
        repo.save(item);
    }

    public Film[] findAll() {
        return repo.findAll();
    }

    public Film[] findLast() {
        int resultCount = repo.findAll().length <= lastCount ? repo.findAll().length : lastCount;
        Film[] tmp = new Film[resultCount];
        for (int i = 0; i < resultCount; i++) {
            tmp[i] = repo.findAll()[repo.findAll().length - 1 - i];
        }
        return tmp;
    }
}