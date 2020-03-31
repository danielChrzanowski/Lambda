package lambdy2;

public class Lambda {
    public static void main(String[] args) {
        java.util.List<String> aList = java.util.Arrays.asList("a21", "a2", "a13", "a4", "b10", "b2", "c13", "c4");

        //odfiltruj b
        //przekonwertuj do wielkiej
        //posortuj
        aList
                .stream()
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(s-> System.out.println(s));
    }


}
