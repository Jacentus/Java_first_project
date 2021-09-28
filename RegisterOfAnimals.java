package com.pl.jmotyka; //

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterOfAnimals {

    private static ArrayList<Animal> listOfAnimals;

    public RegisterOfAnimals() {}

    public void addAnimalToList(Animal animalToBeAdded){
        getListOfAnimals().add(animalToBeAdded);
    }

    public boolean checkForSameAnimal(Animal animalToBeAdded, ArrayList<Animal> listToBeChecked){
        boolean hasBeenFound = false;
        for (int i = 0; i<listToBeChecked.size(); i++){
            if (listToBeChecked.get(i).equals(animalToBeAdded)){
                hasBeenFound = true;
            }
        }
        return hasBeenFound;
    }

    public void displayTypeAndNameOfAllAnimals(){
        for (int i = 0; i<getListOfAnimals().size();i++){
            System.out.println("["+(i+1)+"]"+ listOfAnimals.get(i).displayYourType()+" "+listOfAnimals.get(i).getName());
        }
    }

    public boolean checkForTurtles(ArrayList<Animal> listToBeChecked){
        boolean hasTurtle = false;
        for (int i = 0; i<listToBeChecked.size(); i++){
            if (listToBeChecked.get(i) instanceof Turtle) {
                hasTurtle = true;
            }
        }
        return hasTurtle;
    }

    public Turtle chooseTurtleToFeed(){
        Scanner scanner = new Scanner(System.in);
        ArrayList turtlesFromRegisterOfAnimals= new ArrayList<Turtle>();
        int numberForATurtle = 0;
        for (int i = 0; i<getListOfAnimals().size();i++){
            if (listOfAnimals.get(i) instanceof Turtle){
                numberForATurtle++;
                turtlesFromRegisterOfAnimals.add(getListOfAnimals().get(i));
                System.out.println("["+numberForATurtle+"]"+ listOfAnimals.get(i).displayYourType()+" "+listOfAnimals.get(i).getName());
            }
        }
        System.out.print("Select number: ");
        int choiceOfTurtleToFeed = scanner.nextInt();
        Turtle turtleToBeFed = (Turtle) turtlesFromRegisterOfAnimals.get(choiceOfTurtleToFeed-1);
        return turtleToBeFed;
        }


    ////////////////////// auto generated Getters & Setters /////////////////////////////////////////////

    public static ArrayList<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    public static void setListOfAnimals(ArrayList<Animal> listOfAnimals) {
        RegisterOfAnimals.listOfAnimals = listOfAnimals;
    }
}
