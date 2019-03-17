// coded this file by code suggestion as in ex.3, i.e. SpringRestApi
// through Martin B. lectures on good Java program design with Spring Framework
// [10 mars 2019]

package se.iths.course.webinteg.bob.labb2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListStorage implements Storage {

    List<Anmalan> allaAnmalan = new CopyOnWriteArrayList<>();

    public ListStorage() {
        loadFromFile();
    }

    public void addAnmalan (Anmalan anmalan) {
        allaAnmalan.add(anmalan);
        saveToFile();
    }

    public void close() {
        saveToFile();
    }

    @Override
    public List<Anmalan> getAll() {
        return allaAnmalan;
    }

    private void loadFromFile() {
        // have a database file and try/catch open file and
        // set to list allaAnmalan (can see ListStorage example)
    }

    private void saveToFile() {
        // define a path,
        // define a new File
        // do an ObjectOutputStream like statement
        // write out allaAnmalan (as in ListStorage, for example)
    }
}
