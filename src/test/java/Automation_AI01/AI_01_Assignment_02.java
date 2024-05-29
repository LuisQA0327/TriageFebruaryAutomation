package Automation_AI01;

import java.util.ArrayList;

public class AI_01_Assignment_02 {
    public static void main(String[] args) {
        ArrayList<String> regions = new ArrayList<>();
        regions.add("Queens");
        regions.add("Brooklyn");
        regions.add("Manhattan");
        regions.add("Bronx");

        ArrayList<Integer> areaCodes = new ArrayList<>();
        areaCodes.add(718);
        areaCodes.add(347);
        areaCodes.add(917);
        areaCodes.add(212);

        for (int i = 0; i < regions.size(); i++) {

            System.out.println("My region is " + regions.get(i) + " and my area code is " + areaCodes.get(i));
        }
    }
}
