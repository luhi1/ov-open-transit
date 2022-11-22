package operatorClient;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Controller systemsManager = new Controller("tempDatabase.txt");
        Operator busDriver = new Operator("tempDatabase.txt");
        int[] deleteList = {0,1};
        systemsManager.removeStatus(deleteList);
    }
}
