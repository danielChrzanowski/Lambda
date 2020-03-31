package comparator2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import static comparator2.Person.*;

public class Comparator {
    public static void main(String[] args) {
        //done 1 Person: name, lastName (opcjonalnie pole obiektowe)
        //done 2 dwa komparatory
        //done 3 wypisac posortowane:
        //3a pierwszy komparator
        //3b oba
        //3c oba, jeden z nich odwrocona kolejnosc

        List<Person> people = List.of(
                new Person("Zbigniew", "Wodecki", new Car("Audi")),
                new Person("Adam", "Kowalski", new Car("Opel")),
                new Person("Cecylia", "Stachurska", new Car("Renault")),
                new Person("Adam", "Adamiak", new Car("Volvo"))
        );

        //pierwszy
        System.out.println("PIERWSZY");
        people.stream()
                .sorted(posortujPoImieniu)
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //oba
        System.out.println("OBA:");
        people.stream()
                .sorted(posortujPoImieniu.thenComparing(posortujPoNazwisku))
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //drugi odwrocony
        System.out.println("ODWROCONY:");
        people.stream()
                .sorted(posortujPoImieniu.thenComparing(posortujPoNazwisku).reversed())
                .forEach(System.out::println);
        System.out.println("-------------------------");

        //car
        System.out.println("CAR:");
        people.stream()
                .sorted(posortujPoCar)
                .forEach(System.out::println);
        System.out.println("-------------------------");
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name, lastName;
    private Car car;

    static java.util.Comparator<Person> posortujPoImieniu = (p1, p2) -> p1.getName().compareTo(p2.getName());
    static java.util.Comparator<Person> posortujPoNazwisku = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
    static java.util.Comparator<Person> posortujPoCar = (p1, p2) -> p1.getCar().getBrand().compareTo(p2.getCar().getBrand());
}

@Data
@AllArgsConstructor
class Car {
    private String brand;


}