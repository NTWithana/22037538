//GADGET class creation 
public class Gadget {

public static void main(String[] args){  
    
}   

public String model;
public String size; 
public double price; //price requires 2 decimals therefore double instead of float 
public int weight;

//constructor for the gadget class with the parameteres  
public Gadget(String gadmodel, String gadsize, double gadprice, int gadweight){ 
//initialize attributes with the parrameters
          model=gadmodel;
          size=gadsize;
          price=gadprice;
          weight=gadweight;
      
}   
// All Acessor methods to return the values.
public String getmodel(){                      
        return model;
    }    

public String getsize(){                      
        return size;
    } 

public int getweight(){                      
        return weight;
    }

public double getprice(){                      
        return price;
    }

public void prompt(){//display the outputs
        System.out.println("Model:-"+ model);//display model of a specific gadget
        System.out.println("Size:-"+ size+ "mm");//display Size in millimeteres
        System.out.println("weight:-"+ weight+ "g");//display weight in grams
        System.out.println("Price:-"+ price+ "£"); //display price in GBP
}



}
      
  
      
  
  
  
      
      
    
      
      
      
  
  