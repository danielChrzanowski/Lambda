package uzycieLambdy;

public class UzycieLambdy {
    public static void main(String[] args) {
        MyInterface zamienNaDuze = s -> s.toUpperCase();

        useLambda(zamienNaDuze, "zamien na duze");
        useLambda(s -> s.toLowerCase(), "zAmIeN nA maLe");

    }

    static void useLambda(MyInterface myInterface, String stringToWork) {
        String str = myInterface.go(stringToWork);
        System.out.println(str);
    }

}

@FunctionalInterface
interface MyInterface {
    String go(String s);
}