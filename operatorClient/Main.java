package operatorClient;

public class Main {

    public static void main(String[] args) {
        Operator busDriver = new Operator("tempDatabase.txt");
        busDriver.addStatus("Hi");
    }
}
