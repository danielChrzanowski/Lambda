package flatMap;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        //done 1 utworz 3 listy intow
        //done 2 utworz liste list i wydrukuj
        //done 3 splaszcz liste uzywajac flatmap, posortuj i wydrukuj

        List<Integer> pierwsze = List.of(5, 7, 11);
        List<Integer> parzyste = List.of(2, 4, 16);
        List<Integer> nieParzyste = List.of(1, 3, 5);

        List<List<Integer>> lista = List.of(pierwsze, parzyste, nieParzyste);
        System.out.println(lista);

        var lista2 = lista
                .stream()
                .flatMap(m -> m.stream())
                .collect(Collectors.toList());
        System.out.println(lista2);

    }

}


/*
    [
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12]
    ]

    flatMap zmieni w:

    [1,2,3,4,5,6,7,8,9,10,11,12]
 */