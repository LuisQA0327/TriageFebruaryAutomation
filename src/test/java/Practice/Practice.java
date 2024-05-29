package Practice;

import java.util.ArrayList;

public class Practice {
    public static void main(String[]args) {
        ArrayList<String> countries = new ArrayList<>();
        //add some values to the countries array list
        countries.add("USA"); //index 0
        countries.add("INDIA"); //index 1
        countries.add("PAKISTAN"); //index 2
        countries.add("BANGLADESH"); //index 3

        ArrayList<Integer> militaryRank = new ArrayList<>();
        militaryRank.add(1);
        militaryRank.add(2);
        militaryRank.add(3);
        militaryRank.add(4);

        System.out.println("The last country is:" + countries.get(3) + " and its military rank is: " + militaryRank.get(3));
    }
}