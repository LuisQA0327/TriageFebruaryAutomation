package Day3_040824;

public class T4_arrayLoopConditions {
    public static void main(String[] args) {


        // we use .equals operator to compare string variables
        // we use == operator to compare integers
        String[] fruits;

        fruits=new String[]{"Apple", "Orange", "Grape", "Strawberry", "Mango"};

        for (int i=0; i< fruits.length; i++){
            if(fruits[i].equals("Grape")) {
                System.out.println("Fruit is " + fruits[i]);
            }
   else if(fruits[i].equals("Mango")){
                System.out.println("Fruit is "+ fruits[i]);
            }//End of if else
        }//End of for loop

        //we're using == sign to compare integer variable types
        int[] age;

        age = new int[]{28, 30, 21, 56, 63};

        for (int i=0; i<age.length; i++){
            if(age[i]==(30)){
                System.out.println("My age is "+ age[i]);
            }
            else if(age[i]==(56)){
                System.out.println("My age is "+ age[i]);
            }//End of if else
        }//End of for loop

    }//End of Main
}//End of class
