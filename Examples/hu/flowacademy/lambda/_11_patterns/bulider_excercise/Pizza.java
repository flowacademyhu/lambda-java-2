package hu.flowacademy.lambda._11_patterns.bulider_excercise;

import java.util.List;

public class Pizza {

    private final String teszta;
    private final String szosz;
    private final List<String> feltetek;
    private final boolean toltottSzel;

    public Pizza(String teszta, String szosz, List<String> feltetek, boolean toltottSzel) {
        this.teszta = teszta;
        this.szosz = szosz;
        this.feltetek = feltetek;
        this.toltottSzel = toltottSzel;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "teszta='" + teszta + '\'' +
                ", szosz='" + szosz + '\'' +
                ", feltetek=" + feltetek +
                ", toltottSzel=" + toltottSzel +
                '}';
    }
}
