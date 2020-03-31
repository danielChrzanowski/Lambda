package comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

import static comparator.Person.posortujPoImieniu;

public class ComparatorClass {
    public static void main(String[] args) {
        List.of(
                new Person("Lukasz", "Kowalski"),
                new Person("Adam", "Kowalski"),
                new Person("Adam", "Nowak")
        )
                .stream()
                .sorted(posortujPoImieniu.thenComparing(Person.posortujPoNaziwsku.reversed()))
                .forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name, lastName;

    static Comparator<Person> posortujPoImieniu = (p1, p2) -> p1.getName().compareTo(p2.getName());
    static Comparator<Person> posortujPoNaziwsku = Comparator.comparing(Person::getLastName);
}