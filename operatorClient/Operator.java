package operatorClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operator {

    private ArrayList<String> statusUpadates = new ArrayList<String>();
    private File database;
    private String databaseFileLocation;

    public Operator(String databaseFile) {
        this.databaseFileLocation = databaseFile;
        this.database = new File(databaseFile);
        this.getStatus();
    }

    public void getStatus() {
        try {
            Scanner myReader = new Scanner(this.database);
            while (myReader.hasNextLine()) {
                this.statusUpadates.add(myReader.nextLine());
            }
            System.out.println(this.statusUpadates);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The database file was unable to be read.");
            e.printStackTrace();
        }
    }

    public void addStatus(String status) {
        try {
            FileWriter myWriter = new FileWriter(this.databaseFileLocation);
            myWriter.write(status);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        this.getStatus();
    }
}
