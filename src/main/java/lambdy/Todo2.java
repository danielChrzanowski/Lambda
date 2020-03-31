package lambdy;

public class Todo2 {
    public static void main(String[] args) {
        //anonimowa
        InterfejsB anonim = new InterfejsB() {
            @Override
            public String go() {
                return "Anonimowa";
            }
        };

        //lambda
        InterfejsB lambda = () -> "lambda";

    }

}

@FunctionalInterface
interface InterfejsB {
    String go();
}

class KlasycznaB implements InterfejsB {
    @Override
    public String go() {
        return "Klasyczna";
    }
}