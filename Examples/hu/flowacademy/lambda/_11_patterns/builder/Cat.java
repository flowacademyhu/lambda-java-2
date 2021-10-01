package hu.flowacademy.lambda._11_patterns.builder;

import java.util.List;

class Cat {

    private final String color;
    private String name;
    private Collar collar;
    private final List<String> toys;

    public Cat(String color, String name, Collar collar, List<String> toys) {
        this.color = color;
        this.name = name;
        this.collar = collar;
        this.toys = toys;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", collar=" + collar +
                ", toys=" + toys +
                '}';
    }
}
