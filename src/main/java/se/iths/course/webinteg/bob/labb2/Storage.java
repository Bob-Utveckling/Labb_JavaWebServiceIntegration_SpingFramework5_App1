// coded this file by code suggestion
// through Martin B. lectures on good Java program design with Spring Framework
// [10 mars 2019]

package se.iths.course.webinteg.bob.labb2;

import java.util.List;

public interface Storage {
    void addAnmalan (Anmalan anmalan);

    void close();

    List<Anmalan> getAll();
}
