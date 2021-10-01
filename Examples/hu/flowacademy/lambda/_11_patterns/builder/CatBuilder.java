package hu.flowacademy.lambda._11_patterns.builder;

import java.util.ArrayList;
import java.util.List;

class CatBuilder {

    private final String color;
    private String name = null;
    private Collar collar = null;
    private final List<String> toys = new ArrayList<>();

    private CatBuilder(String color) {
        this.color = color;
    }

    public static CatBuilder ofColor(String color) {
        return new CatBuilder(color);
    }

    public CatBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CatBuilder withCollar(Collar collar) {
        this.collar = collar;
        return this;
    }

    public CatBuilder addToy(String toy) {
        this.toys.add(toy);
        return this;
    }

    public Cat build() {
        return new Cat(color, name, collar, toys);
    }
}
