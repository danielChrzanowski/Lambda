package lambdy;

import java.lang.annotation.Annotation;

public class Todo1 {
    public static void main(String[] args) {
        //anonimowa
        InterfejsA anonim = new InterfejsA() {
            @Override
            public void go() {
                System.out.println("Anonimowa");
            }
        };

        //lambda
        InterfejsA lambda = () -> System.out.println("Lambda");
    }

}

//interfejs
@FunctionalInterface
interface InterfejsA {
    void go();
}

//klasyczna
class KlasaA implements InterfejsA {
    @Override
    public void go() {
        System.out.println("Klasyczna");
    }
}