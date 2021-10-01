package hu.flowacademy.lambda._11_patterns.builder;

class Collar {

    private final String color;
    private final Size size;

    public Collar(String color, Size size) {
        this.color = color;
        this.size = size;
    }

    public enum Size {
        S, M, L
    }

    @Override
    public String toString() {
        return "Collar{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
