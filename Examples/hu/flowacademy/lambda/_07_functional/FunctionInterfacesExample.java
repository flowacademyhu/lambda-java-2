package hu.flowacademy.lambda._07_functional;

import java.nio.file.DirectoryStream;
import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionInterfacesExample {

    public void test_Consumer() {
        //1. Implementing Method with consumer Interface
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer);

        System.out.println("********************");

        //(2) Using lambda expression, forEach method needs a Consumer interface.
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer<String> consumer1 = (s) -> System.out.println(s);//The lambda expression returns a Consumer interface
        stream.forEach((s) -> System.out.println(s));
        //A more direct approach
        //stream.forEach((s) -> System.out.println(s));
        System.out.println("********************");

        //(3) Use method reference, method reference is also a consumer.
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer consumer2 = System.out::println;
        stream.forEach(consumer2);
        //A more direct approach
        //stream.forEach(System.out::println);
    }

    public void test_Supplier() {
        //(1) Using the Supplier interface, there is only one get method, no parameters, and a value is returned.
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //Returns a random value
                return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());

        System.out.println("********************");

        //(2) Using lambda expression,
        supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());
        System.out.println("********************");

        //(3) Use method quotation
        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());
    }

    public void test_Supplier2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        //Returns an optional object
        Optional<Integer> first = stream.filter(i -> i > 4)
                .findFirst();

        //Opti objects have methods that require Supplier interfaces
        //orElse, if there is a number in first, it returns that number, and if not, it returns the number passed in.
        System.out.println(first.orElse(1));
        System.out.println(first.orElse(7));

        System.out.println("********************");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //Returns a random value
                return new Random().nextInt();
            }
        };

        //orElseGet, if there is a number in first, returns this number, if not, returns the value returned by supplier
        System.out.println(first.orElseGet(() -> new Random().nextInt()));
    }

    public void test_Predicate() {
        //(1) Using the Predicate interface, there is only one test method, passing in a parameter and returning a bool value.
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 5){
                    return true;
                }
                return false;
            }
        };

        System.out.println(predicate.test(6));

        System.out.println("********************");

        //(2) Using lambda expression,
        predicate = (t) -> t >= 1;
        System.out.println(predicate.test(1));
        System.out.println("********************");

    }

    public void test_Predicate2() {
        //Predicate serves as a filter interface, and Predicate serves as a judgment.
        Predicate<Integer> predicate = integer -> {
            if(integer > 5){
                return true;
            }
            return false;
        };

        Stream<Integer> stream = Stream.of(1, 23, 3, 4, 5, 56, 6, 6);

        List<Integer> list = stream.filter(i -> i > 5).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("********************");
    }

    public void test_Function() {
        //(1) Using map method, the first parameter of generics is the type before conversion and the second is the type after conversion.
        Function<String, Integer> function = s -> {
            return s.length();//Gets the length of each string and returns
        };

        Function<String, Integer> function1 = s -> {
            return s.length() + 1;//Gets the length of each string and returns
        };

        Stream<String> stream = Stream.of("aaa", "bbbbb", "cccccc");
        Stream<Integer> stream1 = stream.map(s -> {
            return s.length();//Gets the length of each string and returns
        });
        stream1.forEach(System.out::println);

        System.out.println("********************");

    }

    public  static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

//        Consumer<String> print = FunctionInterfacesExample::print;
//        Consumer<String> print2 = s -> FunctionInterfacesExample.print(s);
//
//        Predicate<String> stringFilter = myString::startsWith;
//        Predicate<String> stringFilter2 = s -> {return myString.startsWith(s);};
//
//        Function<String, String> myfunc = String::valueOf;
//
//        String mystring = "alma";
//        Function<String, Integer> stringIntegerFunction = String::length;


        String myString = "alma123";
        Predicate<String> myStringStartsWith = myString::startsWith;
        BiFunction<String, String, Boolean> stringStartsWith = String::startsWith;

        System.out.println(myStringStartsWith.test("alma"));
        System.out.println(stringStartsWith.apply("alma456", "alma"));

        Supplier<ArrayList> newArrayList = ArrayList::new;

        IntToDoubleFunction myIntSupplier = (i) -> (double) i;

        ArrayList arrayList = newArrayList.get();
//
//        Stream.of("alma", "körte").filter(myString::startsWith).forEach(System.out::println);
    }

}
