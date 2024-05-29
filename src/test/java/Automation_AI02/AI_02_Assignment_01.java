package Automation_AI02;

import java.util.ArrayList;

public class AI_02_Assignment_01 {
    public static void main(String[] args) {
        //Create ArrayList
        ArrayList<String> countries = new ArrayList<>();
        //Add String values
        countries.add("USA"); // Index 0
        countries.add("India"); // Index 1
        countries.add("Bangladesh"); // Index 2
        countries.add("UK"); // Index 3
        countries.add("Egypt"); // Index 4
        //Define whileLoop
        int i = 0;
        while (i < countries.size()) {
            //Print out Bangladesh and USA
            if (i==0) {
                System.out.println(countries.get(i));
            }else if(i==2){
                System.out.println(countries.get(i));
            }//End of conditional statement
            i++;
        }//End of whileLoop
    }//End of main
}//End of class

