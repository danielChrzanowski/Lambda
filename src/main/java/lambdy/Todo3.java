package lambdy;

public class Todo3 {
    public static void main(String[] args) {
        InterfejsC anonimowa = new InterfejsC() {
            @Override
            public String go(String name) {
                return name;
            }
        };

        InterfejsC lambda = name -> name;
    }

}

@FunctionalInterface
interface InterfejsC {
    String go(String name);
}

class KlasycznaC implements InterfejsC {
    @Override
    public String go(String name) {
        return name;
    }
}