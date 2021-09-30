package hu.flowacademy.lambda._08_streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
//        acronym();
//        performance();
//        streamProcessedTwice();
//        groupingByCollector();
//        joinerCollector();

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Predicate<Person> stratsWithP = p -> p.name.startsWith("X");
        Predicate<Person> over18 = p -> p.age >= 18;

        Function<Person, String> getName = p -> p.name;
        Function<String, Integer> countChars = s -> s.length();

        Function<Person, Integer> getNameCharCount = getName.andThen(countChars);

        Consumer<Object> log = System.out::println;
        Consumer<Object> log2 = (o) -> {
            System.out.println("!");
        };

        Optional<Person> firstP = persons.stream().filter(stratsWithP).findFirst();
        if (firstP.isPresent()) {
        }

        Optional<Person> optionalPerson = Optional.ofNullable(persons.get(0));
        Optional<Person> optionalPerson2 = Optional.ofNullable(null);

        System.out.println(optionalPerson2.orElse(persons.get(1)));
    }

    private static void acronym() {
        String fullName = "United States of America";

        // órai példa
        String acronym1 = new Scanner(fullName).tokens()
                .filter(word -> word.length() > 2)
                .map(word -> word.substring(0, 1))
                .collect(Collectors.joining());

        System.out.println(acronym1);

        // az óra végén kipróbáltuk, hogy lehet leválogatni az összes nagybetűt:
        String acronym2 = fullName.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Character.isUpperCase(c))
                .map(c -> String.valueOf(c))
                .collect(Collectors.joining());

        System.out.println(acronym2);
    }

    public static void performance() {
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

    public static void streamProcessedTwice() {
        //Javítsd
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        System.out.println(stream.anyMatch(s -> s.endsWith("2")));    // ok
        System.out.println(stream.noneMatch(s -> s.endsWith("4")));   // exception
    }

    public static void groupingByCollector() {
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

        // megvalósítás saját collectorral:
        Map<Integer, List<Person>> personsByAge2 = persons
                .stream()
                .collect(
//                        HashMap::new,
                        () -> new HashMap<Integer, List<Person>>(),
                        (map, person) -> map.computeIfAbsent(person.age, (p) -> new ArrayList<>()).add(person),
                        (map1, map2) -> map1.putAll(map2)
                );
    }

    public static void joinerCollector() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        // példák:
        Predicate<Person> stratsWithP = p -> p.name.startsWith("X");
        Predicate<Person> over18 = p -> p.age >= 18;

        stratsWithP.or(over18);


        // predicate1: több mint 3 karakteres név
        // predicate2: kora páros

        // egyik vagy másik teljesüljön
        // Person to String átalakítás legyen megvalósítva toString metódus referenciával
        // végén join vesszővel



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

        String over18Names = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(Person::toString)
                .collect(Collectors.joining(", "));

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
