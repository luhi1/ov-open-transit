package operatorClient;

public class Controller extends BusSystems{

    public Controller(String databaseFile) {
        super(databaseFile);
    }

    public void removeStatus(int[] i){
        /*Replace if with try and catch */
        if (i.length < this.statusUpdates.size()){
            try {
                for (int j : i) {
                    super.removeStatus(i[j]);
                    i[j+1] -=1;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bounds");
                e.printStackTrace();
            }
        } else {
            System.out.println("Trying to delete more lines than the file contains.");
        }
    }
}
