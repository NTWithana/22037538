public class MP3 extends Gadget {

public static void main(String[] args){  
   
        
    } 
private int availMem; // One attribute that belongs to this class
        
    // Constructor for the mobile subclass
public MP3(String gadmodel, String gadsize, double gadprice, int gadweight, int availmem) {
        super(gadmodel, gadsize, gadprice, gadweight); // Calling the superclass constructor
        availMem = availmem;
    }

    // Accessor method for available memory
public int getAvailMem() {
        return availMem;
    }

    // download song to the MP3 device
public void addSong(int songSize) { // songSize refers to the size of the song being added                  
        if (songSize <= availMem) {
            availMem -= songSize;
            System.out.println("Your downloaded song is now available to listen.");
        } else {
            System.out.println("insufficiant memory to download this song.");
        }
    }

    // Method to delete song from the MP3
public void delSong(int songSize) {
        availMem += songSize;
        System.out.println("The song has been deleted from the storage and is no longer available to listen.");
}

public void prompt() {
        super.prompt(); // Call the superclass (Gadget) to retrieve existing display methods
        System.out.println("Remaining Memory of this device: " + availMem + " MB"); // display available memory of the MP3 device
}


}
