package lambdy3;

import lombok.ToString;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lambdy3.Person.*;

public class Lambda {
    public static void main(String[] args) {
        //done 1 Klasa person: name, lastName, age
        //done 2 3 predykaty w klasie: imieNaA, nazwiskoNaB, wiekPowyzej20lat
        //done 3 kolekcja List<Person> (>5 elementow)
        /*done 4 stream API:
            - odfiltruj uzywajac 3 predykatow
            - wypisz do konsoli odfiltrowane elementy
        */

        List<Person> people = List.of(
                new Person("Ala", "Kowalska", 25),
                new Person("Bogdan", "Bogdanowicz", 18),
                new Person("Bena", "Nowak", 35),
                new Person("Adam", "Bogdanowicz", 21),
                new Person("Zenek", "Jakiś", 15),
                new Person("Ania", "Bednarek", 40)
        );

        people
                .stream()
                .filter(imieZaczynaSieNaAPredicate.and(nazwiskoZaczynaSieNaBPredicate).and(wiekPowyzej20LatPredicate))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toString()));

    }


}

@ToString
class Person {
    String name, lastName;
    int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    static Predicate<Person> imieZaczynaSieNaAPredicate = person -> person.name.toUpperCase().startsWith("A");
    static Predicate<Person> nazwiskoZaczynaSieNaBPredicate = person -> person.lastName.toUpperCase().startsWith("B");
    static Predicate<Person> wiekPowyzej20LatPredicate = person -> person.age > 20;
}