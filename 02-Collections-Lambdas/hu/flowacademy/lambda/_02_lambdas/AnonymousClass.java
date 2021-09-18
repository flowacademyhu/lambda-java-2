package hu.flowacademy.lambda._02_lambdas;

import java.util.*;
import java.util.function.*;

public class AnonymousClass {

    static interface Hello {
        public void sayHi();
    }

    public static void main(String args[]){

        Hello german = new Hello() {
            @Override
            public void sayHi() {
                System.out.println("Hallo Welt!");
            }
        };

        german.sayHi();

        Hello english = () -> System.out.println("Hello World!");

        english.sayHi();
    }
}
