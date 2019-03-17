package se.iths.course.webinteg.bob.labb2;

import java.util.ArrayList;

public class Anmalan {
    private String name;
    private String fardighet1;
    private String fardighet2;
    private String fardighet3;
    private String fardighet4;
    private String fardighet5;
    private String forslag;
    //private ArrayList<String> jagKan;
    //private ArrayList<String> mittForslag;

    public Anmalan(String name, String fardighet1,
                   String fardighet2, String fardighet3,
                   String fardighet4, String fardighet5,
                   String forslag ) {
        this.name = name;
        this.fardighet1 = fardighet1;
        this.fardighet2 = fardighet2;
        this.fardighet3 = fardighet3;
        this.fardighet4 = fardighet4;
        this.fardighet5 = fardighet5;
        this.forslag = forslag;

    }

    @Override
    public String toString() {
        return ("name: " + this.name + ", " +
                "färdighet 1: " + this.fardighet1 + ", " +
                "färdighet 2: " + this.fardighet2 + ", " +
                "färdighet 3: " + this.fardighet3 + ", " +
                "färdighet 4: " + this.fardighet4 + ", " +
                "färdighet 5: " + this.fardighet5 + ", " +
                "forslag: " + this.forslag
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFardighet1() {
        return fardighet1;
    }

    public void setFardighet1(String fardighet1) {
        this.fardighet1 = fardighet1;
    }

    public String getFardighet2() {
        return fardighet2;
    }

    public void setFardighet2(String fardighet2) {
        this.fardighet2 = fardighet2;
    }

    public String getFardighet3() {
        return fardighet3;
    }

    public void setFardighet3(String fardighet3) {
        this.fardighet3 = fardighet3;
    }

    public String getFardighet4() {
        return fardighet4;
    }

    public void setFardighet4(String fardighet4) {
        this.fardighet4 = fardighet4;
    }

    public String getFardighet5() {
        return fardighet5;
    }

    public void setFardighet5(String fardighet5) {
        this.fardighet5 = fardighet5;
    }

    public String getForslag() {
        return forslag;
    }

    public void setForslag(String forslag) {
        this.forslag = forslag;
    }
}
