package map;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Mapa {
    public static void main(String[] args) {
        var imiona = List.of(
                new Person("Zbigniew", "Wodecki"),
                new Person("Adam", "Kowalski"),
                new Person("Cecylia", "Stachurska"),
                new Person("Adam", "Adamiak")
        ).stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

        System.out.println(imiona);

////////////////////////////////////////////////////////

        var imiona2 = List.of(
                "Lukasz-Wyspianski",
                "Ania-Kowalska",
                "Jan-Kowalski"
        ).stream()
                .map(p -> p.split("-")[0])
                .collect(Collectors.toList());

        System.out.println(imiona2);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name, lastName;
}