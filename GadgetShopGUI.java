import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShopGUI extends JFrame {
    private ArrayList<Gadget> gadgets;// array list variable
    //text field variables
    private JTextField Gmodel;    
    private JTextField Gprice;
    private JTextField Gweight;
    private JTextField Gsize;
    private JTextField mobnum; 
    private JTextField calldur;
    private JTextField callcredit; 
    private JTextField mp3mem; 
    private JTextField download;
    private JTextField searchterm;
    private JTextField musicname;
    
    //all button variables
    private JButton AddMob ;
    private JButton AddMp3 ;
    private JButton takecall;
    private JButton downmusic ;
    private JButton displayall ;
    private JButton Search;
    private JTextArea Terminal;

    public GadgetShopGUI() { //gadgetshop gui creation 
        gadgets = new ArrayList<>();

        setTitle("GadgetShop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("options");
        JMenuItem clearMenu = new JMenuItem("Clear");
        JMenuItem aboutMenu = new JMenuItem("About");
        clearMenu.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                clearall();
            }
        });
        
        aboutMenu.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                Info();
            }
        });
        
        
        fileMenu.add(clearMenu);
        fileMenu.add(aboutMenu);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Create the pannel to take user inputs containing the textfields
        JPanel inputPanel = new JPanel(new GridLayout(11, 3, 0, 8));

        Gmodel= new JTextField();
        inputPanel.add(new JLabel("Enter Model(Mp3 or Mobile):"));
        inputPanel.add(Gmodel);

        Gsize = new JTextField();
        inputPanel.add(new JLabel("Enter Size:"));
        inputPanel.add(Gsize);

        Gprice = new JTextField();
        inputPanel.add(new JLabel("Enter Price(£):"));
        inputPanel.add(Gprice);

        Gweight = new JTextField();
        inputPanel.add(new JLabel("Enter Weight(g):"));
        inputPanel.add(Gweight);
        
        mobnum = new JTextField();
        inputPanel.add(new JLabel("Enter Mobile Number:"));
        inputPanel.add(mobnum);
        
        calldur = new JTextField();
        inputPanel.add(new JLabel("Enter call duration:"));
        inputPanel.add(calldur);
        
        callcredit = new JTextField();
        inputPanel.add(new JLabel("Enter Credit(£):"));
        inputPanel.add(callcredit);
        
        mp3mem = new JTextField();
        inputPanel.add(new JLabel("Enter MP3 memory(MB):"));
        inputPanel.add(mp3mem);
        
        download = new JTextField();
        inputPanel.add(new JLabel("Music size (MB):"));
        inputPanel.add(download);
        
        musicname = new JTextField();
        inputPanel.add(new JLabel("Enter Music name:"));
        inputPanel.add(musicname);        
        
        searchterm = new JTextField();
        inputPanel.add(new JLabel("Search a gadget or use a gadget:"));
        inputPanel.add(searchterm);

// seperate panel for buttons
JPanel buttonpanel = new JPanel(new GridLayout(2, 3, 0, 0));
    
AddMob = new JButton("Store Mobilephone"); //create add mobile button
AddMob.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        //to  Get mobile details from the user via GUI
        String model = Gmodel.getText(); 
        String size = Gsize.getText();
        double price;
        int weight;
        int creditbal;
    
        //check any required fields are empty
        try { 
            price = Double.parseDouble(Gprice.getText());
            weight = Integer.parseInt(Gweight.getText());
            creditbal = Integer.parseInt(callcredit.getText());
        } catch (NumberFormatException ex) { //check the values entered by user are in compatible format
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Please fill all the fields & Use numeric values when adding Price, Weight of your mobilephone!","ERROR!", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        // Check if user enters any information on other irrelavent text fields
        if (!mobnum.getText().isEmpty() || !mp3mem.getText().isEmpty()  || !download.getText().isEmpty() || !musicname.getText().isEmpty() || !searchterm.getText().isEmpty() || !calldur.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Some Iformation isn't compatible with Mobile Device! Please enter values only for model, size, price, weight, calling credit","ERROR!",JOptionPane.ERROR_MESSAGE);
            return; 
        }

        // after all the checks Create a new Mobile object with the user inputs and store that in array list 
        Mobile newMobile = new Mobile(model, size, price, weight,creditbal);
        gadgets.add(newMobile);
        
        int GadgetID = gadgets.size();
        JOptionPane.showMessageDialog(GadgetShopGUI.this, "Your Mobile Phone Stored in the Gadget Shop Successfully. Your Mobile Phone ID is:"+ GadgetID);
    
        clearall();
    }
});
buttonpanel.add(AddMob);

//create add mp3 button
AddMp3 = new JButton("Store MP3 Player");
AddMp3.addActionListener(new ActionListener() {
            
        public void actionPerformed(ActionEvent e) {
        // Get inputs from the user via GUI
        String model = Gmodel.getText(); 
        String size = Gsize.getText();
        
        double price;
        int weight;
        int availmem;
        // checks same as add mobile button
        try {
            price = Double.parseDouble(Gprice.getText());
            weight = Integer.parseInt(Gweight.getText());
            availmem = Integer.parseInt(mp3mem.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Please fill all the fields or Use numeric values when adding Price, weight, available memmory","ERROR!", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        // Check if there's any input in other irrelavent text fields
        if (!mobnum.getText().isEmpty() || !calldur.getText().isEmpty() || !callcredit.getText().isEmpty()  || !download.getText().isEmpty() || !musicname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Input is not compatible with MP3 Device! Please enter values only for model, size, price, weight, Available memmory","ERROR!",JOptionPane.ERROR_MESSAGE);
            return;
        
            
        }
        

        // Create a new Mp3 object with the retrieved values
        MP3 newMP3 = new MP3(model, size, price, weight,availmem);
        gadgets.add(newMP3);
        
        int GadgetID = gadgets.size();
        
        
        JOptionPane.showMessageDialog(GadgetShopGUI.this, "Your Mp3 Device Stored in the Gadget Shop Successfully. Your MP3 Device ID is:"+ GadgetID);
                
        clearall();               
                
            }
});
buttonpanel.add(AddMp3);



takecall = new JButton("Take a Call");
takecall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
if (searchterm.getText().isEmpty() || mobnum.getText().isEmpty() || calldur.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "please select a mobile phone and add your phonenumber and the duration of the call! ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(!callcredit.getText().isEmpty() || !download.getText().isEmpty() || !musicname.getText().isEmpty() || !mp3mem.getText().isEmpty() || !mp3mem.getText().isEmpty() || !Gmodel.getText().isEmpty() ||!Gprice.getText().isEmpty() || !Gsize.getText().isEmpty() || !Gweight.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "please only add phonenumber and duration to make the call! ,", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }       
int takemobile = Integer.parseInt(searchterm.getText()) - 1;
        

if (takemobile < 0 || takemobile >= gadgets.size()) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Enter the valid Gadget ID of the Mobile For the call ", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve the selected gadget from the gadgets list
Gadget selectedGadget = gadgets.get(takemobile);

        // Check if the selected gadget is a Mobile
if (selectedGadget instanceof Mobile) {
            Mobile selectedMobile = (Mobile) selectedGadget;
            String phoneNumber = mobnum.getText();
            int callDuration = Integer.parseInt(calldur.getText());

            // Check if the credit balance of the selected device sufficient for the call
            if (selectedMobile.getCreditBal() >= callDuration) { 
                //display the results on text area
                Terminal.append("In a call with " + phoneNumber + " for " + callDuration + " Mins. calling from:-" + selectedGadget.getmodel() + "\n");
                // Deduct the call duration from the credit balance 
                selectedMobile.takeCall(phoneNumber, callDuration);
                Terminal.append("Remaining Credit balance of this device:-" + selectedMobile.getCreditBal() + "£\n");
                Terminal.append("---------------------------------------------------------------------------------"+"\n");
            
            } else {
                JOptionPane.showMessageDialog(GadgetShopGUI.this, "Insufficient credit balance of this device to make the call please select another device", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Selected gadget is not a mobile phone Select a Mobile phone and try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
}
            
            
            
            
});
buttonpanel.add(takecall);
      

downmusic = new JButton("Download Music");

downmusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
    if (searchterm.getText().isEmpty() || download.getText().isEmpty() || musicname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Please select a mp3 Device & choose a music and add size of the music before downloading the song ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(!callcredit.getText().isEmpty() || !mp3mem.getText().isEmpty() || !mp3mem.getText().isEmpty() || !Gmodel.getText().isEmpty() ||!Gprice.getText().isEmpty() || !Gsize.getText().isEmpty() || !Gweight.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "please only enter music name and music size to download the music! ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        
        }
        

    int takemp3 = Integer.parseInt(searchterm.getText()) - 1;
    // Assuming the index starts from 1

    if (takemp3 < 0 || takemp3 >= gadgets.size()) {
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Enter a valid Gadget ID of the Mp3 to download the music ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // select gadget from the gadgets list
    Gadget selectedGadget = gadgets.get(takemp3);

        // Check if the selected gadget is a Mp3
    if (selectedGadget instanceof MP3) {
            MP3 selectedMP3 = (MP3) selectedGadget;
            String music = musicname.getText();
            int Songsize = Integer.parseInt(download.getText());

            // Check if the memmory is sufficiant to download the music
            if (selectedMP3.getAvailMem() >= Songsize) {
                Terminal.append("Music downloaded successfully. \n"+ music + "now available to listen on" + selectedGadget.getmodel() + "\n");
                // Deduct the music size from avaialble memmory 
                selectedMP3.addSong(Songsize);
                Terminal.append("Remaining memmory of this Mp3 Device" + selectedMP3.getAvailMem() + "Mb\n");
                Terminal.append("-----------------------------------------------------------------------------------------------------------------------------------"+"\n");
            
            
            } else { //insufficiant memmory
                JOptionPane.showMessageDialog(GadgetShopGUI.this, "Inufficiant memmory to download This song", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {//if the gadget is not a mp3
            JOptionPane.showMessageDialog(GadgetShopGUI.this, "Please select a mp3 device to download Music", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
            
            
});


buttonpanel.add(downmusic);
        
        
        
displayall = new JButton("Display All");
displayall.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                alldevices();
            }
});
buttonpanel.add(displayall);


//my own button functonality 
Search = new JButton("Search");
Search.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String search = searchterm.getText();
        int gadgetID;
        try {
            gadgetID = Integer.parseInt(search);
            if (gadgetID < 1 || gadgetID > gadgets.size()) {
                
                JOptionPane.showMessageDialog(GadgetShopGUI.this, "This Gadget not availbale at GadgetShop", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Gadget gadget = gadgets.get(gadgetID - 1);
                String convertprompt = "Model:- " + gadget.getmodel() + "\n" +
                                       "Size:- " + gadget.getsize() + "mm\n" +
                                       "Weight:- " + gadget.getweight() + "g\n" +
                                       "Price:- " + gadget.getprice() + "£\n";
                if (gadget instanceof Mobile) {
                    int creditBalance = ((Mobile) gadget).getCreditBal();
                    convertprompt += "Credit balance of this phone:- " + creditBalance + "£\n";
                } else if (gadget instanceof MP3) { 
                    int availablemem = ((MP3) gadget).getAvailMem();
                    convertprompt += "available memmory of this device:- " + availablemem + "Mb\n";
                }
                Terminal.append("________________________________________________________________________________________________________________");
                Terminal.setText(convertprompt);
            }
        } catch (NumberFormatException ex) {
            Terminal.setText("Invalid input. Please enter a valid gadget ID.");
        }
    }
});            
            
buttonpanel.add(Search);
        
Terminal = new JTextArea(50, 20); //text area to diaplay results
Terminal.setEditable(false); // make the terminal read only
JScrollPane scrollPane = new JScrollPane(Terminal);
        
        
// Add panels to frame
add(inputPanel, BorderLayout.CENTER);
add(buttonpanel, BorderLayout.SOUTH);
add(scrollPane, BorderLayout.EAST);

setVisible(true);//make pannels visible to user
}


//method to display all devices when pressed display all button
private void alldevices() { 
         
        for (int X = 0; X < gadgets.size(); X++) { //loop to itterate through the objects in array
            Gadget gadget = gadgets.get(X);
        //convert all the results to string using string builder 
        String convertprompt = "Model:- " + gadget.getmodel() + "\n" +
                                   "Size:- " + gadget.getsize() + "mm\n" +
                                   "Weight:- " + gadget.getweight() + "g\n" +
                                    "Price:- " + gadget.getprice() + "£\n";
        if (gadget instanceof Mobile) { //if gadget is a mobile retrieve the credit balance 
            int creditBalance = ((Mobile) gadget).getCreditBal();
            convertprompt += "Credit balance of this phone:- " + creditBalance + "£\n";
        }else if (gadget instanceof MP3){ //if gadget is a mp3 object to retrieve the available memmory
            int availablemem = ((MP3) gadget).getAvailMem();
            convertprompt += "available memmory of this device:- " + availablemem + "Mb\n";
        }                            
        Terminal.append(convertprompt); 
        Terminal.append("Gadget ID: " + (X + 1) + "\n");
        Terminal.append("____________________________________________________________________________________________________________________"+"\n");
    }
}
    
private void Info() {
        
         JOptionPane.showMessageDialog(this,"Student ID :- 22037538", "Gadget Shop by Naveen V 1.9", JOptionPane.INFORMATION_MESSAGE);
    
}
    
//clear method to clear all text fields   
private void clearall() {
        Gmodel.setText("");
        Gsize.setText("");
        Gprice.setText("");
        Gweight.setText("");
        callcredit.setText("");
        calldur.setText("");
        mp3mem.setText("");
        download.setText("");
        musicname.setText("");
        searchterm.setText("");
        mobnum.setText("");
        Terminal.setText("");
}

    
public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GadgetShopGUI();
            }
        });
    }
}
