package hu.flowacademy.lambda._08_streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
    }

    public static void test1() {
        //Hogyan javithatnank performancia szempontbol?
        Set<String> result = Stream.of("d2", "a2", "b1", "b3", "c4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.endsWith("2");
                })
                .collect(Collectors.toSet());
        System.out.println(result);
    }

    public static void test2() {
        //Javítsd
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        System.out.println(stream.anyMatch(s -> s.endsWith("2")));    // ok
        System.out.println(stream.noneMatch(s -> s.endsWith("4")));   // exception
    }

    public static void test3() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        // age 18: [Max]
        // age 23: [Peter, Pamela]
        // age 12: [David]
    }

    public static void test4() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),          // accumulator
                        (j1, j2) -> j1.merge(j2),                       // combiner
                        StringJoiner::toString);                        // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
    }

    static class Person {
        String name;
        String email;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
