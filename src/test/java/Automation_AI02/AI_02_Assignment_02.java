package Automation_AI02;

public class AI_02_Assignment_02 {
    public static void main(String[] args) {
        //Print Grade
        int grade = 45;

        if (grade >=90 && grade <= 100){
            System.out.println("Student grade is an A");
        } else if (grade >=80 && grade <= 89) {
            System.out.println("Student grade is a B");
        } else if (grade >=70 && grade <= 79) {
            System.out.println("Student grade is a C");
        } else if (grade >=60 && grade <= 69){
            System.out.println("Student grade is a D");
        } else if (grade > 100){
            System.out.println("grade out of bounds");
        } else {
            System.out.println("Student grade is an F");
        }//End of conditional statement
    }//End of main
}//End of class
