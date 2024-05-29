package Day4_041524;

import java.util.HashMap;

public class T1_HashMap {
    public static void main(String[] args) {
    //create a hashmap consisting of name and age of Triage Students
        HashMap<String, Integer> triageStudents = new HashMap<>();
        //add some values for the triageStudents hashmap
        triageStudents.put("Oyon", 25);
        triageStudents.put("Shakeb", 29);
        triageStudents.put("Tanvir", 27);
        triageStudents.put("Angie", 21);
        //print out size of the hashmap
        System.out.println("The size of the map is" + triageStudents.size());
        //print out the content of the hashmap
        System.out.println(triageStudents);
        //print out Oyons age
        int oyonsAge = triageStudents.get("Oyon");
        System.out.println("Oyons age is " + oyonsAge );
        //print out Noyons age only if it exists in the data set
        if(triageStudents.containsKey("Noyon")){
            System.out.println("Noyons age is " + triageStudents.get("Noyon"));
        }else {
            System.out.println("Noyon does not exist in the data set");
        }//end if else
    }//end of main
}//end of class
