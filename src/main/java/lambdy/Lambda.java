package lambdy;

public class Lambda {
    public static void main(String[] args) {
        MyInterface impl1 = new KlasycznaImplementacja();

        MyInterface impl2 = name -> name.toUpperCase();

        System.out.println(impl1);
        System.out.println(impl2);
    }


}

@FunctionalInterface
interface MyInterface {
    String go(String name);
}

class KlasycznaImplementacja implements MyInterface {
    @Override
    public String go(String name) {
        return name;
    }
}

//done 1 void go();                   - interfejs, klasyczna implementacja, klasa anonimowa, lambda
//done 2 String go();                 - interfejs, klasyczna implementacja, klasa anonimowa, lambda
//done 3 String go(String name);      - interfejs, klasyczna implementacja, klasa anonimowa, lambda