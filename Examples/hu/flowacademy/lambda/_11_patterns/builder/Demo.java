package hu.flowacademy.lambda._11_patterns.builder;

public class Demo {

    public static void main(String[] args) {
        Cat strayCat = CatBuilder.ofColor("gray").build();
        Cat petCat = CatBuilder.ofColor("black")
                .withName("Salem")
                .withCollar(new Collar("blue", Collar.Size.M))
                .addToy("plush mouse")
                .addToy("ball")
                .build();

        System.out.println(strayCat);
        System.out.println(petCat);
    }
}
