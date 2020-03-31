package lambdy2;

import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

import static lambdy2.Person.imieKonczySieNaAPredicate;
import static lambdy2.Person.imieZaczynaSieNaBPredicate;

public class Predicate {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ala"),
                new Person("Bogdan"),
                new Person("Bena")
        );

        var collect = people
                .stream()
                .filter(imieZaczynaSieNaBPredicate.and(imieKonczySieNaAPredicate))
                .collect(Collectors.toList());
        System.out.println(collect);

    }

}

@ToString
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    static java.util.function.Predicate<Person> imieZaczynaSieNaBPredicate = person -> person.name.toUpperCase().startsWith("B");
    static java.util.function.Predicate<Person> imieKonczySieNaAPredicate = person -> person.name.toUpperCase().endsWith("A");
}