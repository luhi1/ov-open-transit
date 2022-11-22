package operatorClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusSystems {

    protected ArrayList<String> statusUpdates = new ArrayList<String>();
    private File database;
    private String databaseFileLocation;

    public BusSystems(String databaseFile) {
        this.databaseFileLocation = databaseFile;
        this.database = new File(databaseFile);
        this.getStatus();
    }

    public ArrayList<String> getStatus() {
        this.statusUpdates = new ArrayList<String>();
        try {
            Scanner myReader = new Scanner(this.database);
            while (myReader.hasNextLine()) {
                this.statusUpdates.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The database file was unable to be read.");
            e.printStackTrace();
        }

        return(this.statusUpdates);
    }

    public void addStatus(String status) {
        try {
            FileWriter myWriter = new FileWriter(this.databaseFileLocation, true);
            myWriter.append("\n"+status);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(this.getStatus());
    }

    public void removeStatus(int i){
        try {
            FileWriter myWriter = new FileWriter(this.databaseFileLocation, false);
            myWriter.write("");
            myWriter.close();

            myWriter = new FileWriter(this.databaseFileLocation, true);
            Scanner myReader = new Scanner(this.database);
            for (var counter = 0; counter < this.statusUpdates.size(); counter++){
                if (!this.statusUpdates.get(counter).contentEquals(this.statusUpdates.get(i))){
                    myWriter.write(this.statusUpdates.get(counter) + "\n");
                }
            }
            myReader.close();
            myWriter.close();
            this.statusUpdates = new ArrayList<String>();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(this.getStatus());
    }   
}
