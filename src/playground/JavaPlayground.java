package playground;

public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
        System.out.println(Person.N_EYES);
        System.out.println(Person.N_HANDS);
    }
}

class Person{
    public static final int N_EYES = 2;
    public static final int N_HANDS = 2;
}
