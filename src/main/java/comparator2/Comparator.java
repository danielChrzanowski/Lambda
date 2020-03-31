package comparator2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import static comparator2.Person.posortujPoImieniu;
import static comparator2.Person.posortujPoNazwisku;

public class Comparator {
    public static void main(String[] args) {
        //done 1 Person: name, lastName (opcjonalnie pole obiektowe)
        //done 2 dwa komparatory
        //done 3 wypisac posortowane:
        //3a pierwszy komparator
        //3b oba
        //3c oba, jeden z nich odwrocona kolejnosc

        List<Person> people = List.of(
                new Person("Zbigniew", "Wodecki"),
                new Person("Adam", "Kowalski"),
                new Person("Cecylia", "Stachurska"),
                new Person("Adam", "Adamiak")
        );

        //pierwszy
        people.stream()
                .sorted(posortujPoImieniu)
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //oba
        people.stream()
                .sorted(posortujPoImieniu.thenComparing(posortujPoNazwisku))
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //drugi odwrocony
        people.stream()
                .sorted(posortujPoImieniu.thenComparing(posortujPoNazwisku).reversed())
                .forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name, lastName;

    static java.util.Comparator<Person> posortujPoImieniu = (p1, p2) -> p1.getName().compareTo(p2.getName());
    static java.util.Comparator<Person> posortujPoNazwisku = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
}