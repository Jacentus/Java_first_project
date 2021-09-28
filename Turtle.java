package com.pl.jmotyka;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.pl.jmotyka.AnimalsInAGarden.*;

public class Turtle extends Animal {

    private TurtleStatus statusOfTurtle;

    public Turtle(String name, SexEnum sex, int age, Location currentLocation, Owner owner, TurtleStatus turtleStatus) {
        super(name, sex, age, currentLocation, owner);
        this.statusOfTurtle = turtleStatus;
    }

    public Turtle(){
        this.setStatusOfTurtle(TurtleStatus.HIDDEN);
    }

    public void feedATurtle(ArrayList listOfAllAnimals, Turtle turtleSearchedFor){
        if (listOfAllAnimals.isEmpty()) {
            System.out.println("There is no turtle you can feed :(");
            return;
        }
        for (int i = 0; i<listOfAllAnimals.size();i++){
            if (listOfAllAnimals.get(i) instanceof Turtle){
                if ((listOfAllAnimals.get(i)).equals(turtleSearchedFor)){
                    System.out.println("Om nom nom nom!");
                    if (((Turtle)listOfAllAnimals.get(i)).getStatusOfTurtle().equals(TurtleStatus.HIDDEN)){
                        ((Turtle) listOfAllAnimals.get(i)).setStatusOfTurtle(TurtleStatus.ACTIVE);
                        System.out.println("I'm out of my shell and I can move now!");
                    } else System.out.println("I've already been out of my shell but thanks anyway!");
                }
            }
        }
    }

    /////////////////////////////////// ANIMAL CLASS METHODS /////////////////////////////////////

@Override
public String displayYourType(){
    return "Turtle";
}

    public void displayFullAnimalInfo(Animal animal){
        System.out.println("Name: " + animal.getName());
        System.out.println("Type: "+ animal.displayYourType());
        System.out.println("Sex: "+ animal.getSex());
        System.out.println("Age: "+ animal.getAge());
        System.out.println("Owner: " + animal.getOwner().getName() + " "+animal.getOwner().getSurname());
        System.out.println("Status: " +((Turtle)animal).getStatusOfTurtle());
        System.out.println("Located at: x="+animal.getCurrentLocation().getxAxisValue()+", y="+animal.getCurrentLocation().getyAxisValue());
        System.out.println("**************************************************************");
    }

    @Override
    public void gatherAnimalInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        this.setName(scanner.next());
        this.setSex(SexEnum.chooseSex());
        System.out.print("Age: ");
        this.setAge(scanner.nextInt());
        System.out.print("Provide info about the Owner. Name: ");
        String ownersName = scanner.next();
        System.out.println("Second name: ");
        String ownersSecondName = scanner.next();
        System.out.print("Surname: ");
        String ownersSurname = scanner.next();
        SexEnum ownersSex = SexEnum.chooseSex();
        System.out.print("Owners age: ");
        int ownersAge = scanner.nextInt();
        Owner newOwner = new Owner(ownersName, ownersSecondName, ownersSurname, ownersSex, ownersAge);
        //moge sprawdzic czy ownera nie ma na liscie... co z duplikatami...?
        this.setOwner(newOwner);
        this.setStatusOfTurtle(TurtleStatus.chooseTurtleStatus());
        this.setCurrentLocation(new Location());
    }

    ////////////////////// .equals() override /////////////////////////////////////////////

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Turtle){
            Turtle turtle = (Turtle)obj;
            if (turtle.getName().equals(this.getName())
                    && Objects.equals(turtle.getSex(),this.getSex())
                    && turtle.getAge() == this.getAge()
                    && turtle.getOwner().equals(this.getOwner())
                    && Objects.equals(turtle.getStatusOfTurtle(),this.getStatusOfTurtle()))
                result = true;
        }
        return result;
    }

    /////////////////////////////////// Writable interface methods /////////////////////////////////////

    @Override
    public String getDataToSave(){

        String result = "";
        result += displayYourType()+"\n";
        result += getName() + "\n";
        result += (getSex() == null ? "" : getSex()) + "\n";
        result += getAge() + "\n";
        result += getCurrentLocation().getxAxisValue() + "\n";
        result += getCurrentLocation().getyAxisValue() + "\n";
        result += getOwner().getDataToSave();
        result += (statusOfTurtle == null ? "" : statusOfTurtle) + "\n";

        return result;
    }

    /////////////////////////////////// MOVABLE INTERFACE METHODS /////////////////////////////////////

    @Override
    public void move(){
        boolean isHidden = getStatusOfTurtle().equals(TurtleStatus.HIDDEN);
        if (isHidden){
            System.out.println("Your Turtle is hidden! You need to feed him first!");
        }
        else {
            System.out.println("Which direction? Select: [1] UP [2] DOWN [3] LEFT [4] RIGHT");
            Scanner scanner = new Scanner(System.in);
            int choiceDirection = scanner.nextInt();
            int X = this.getCurrentLocation().getxAxisValue();
            int Y = this.getCurrentLocation().getyAxisValue();
            switch (choiceDirection) {
                case 1:
                    if (Y>=MAX){
                        System.out.println("Your animal cannot move up! It's next to the fence!");
                        break;
                    }
                    else {
                        this.getCurrentLocation().setyAxisValue(Y+1);
                        System.out.println("New position: x axis = "+getCurrentLocation().getxAxisValue() + ", y axis = "+getCurrentLocation().getyAxisValue());
                        break;
                    }
                case 2:
                    if (Y<=MIN){
                        System.out.println("Your animal cannot move down! It's next to the fence!");
                        break;
                    }
                    else {
                        this.getCurrentLocation().setyAxisValue(Y-1);
                        System.out.println("New position: x axis = "+getCurrentLocation().getxAxisValue() + ", y axis = "+getCurrentLocation().getyAxisValue());
                        break;
                    }
                case 3:
                    if (X<=MIN){
                        System.out.println("Your animal cannot move left! It's next to the fence!");
                        break;
                    }
                    else{
                        this.getCurrentLocation().setxAxisValue(X-1);
                        System.out.println("New position: x axis = "+getCurrentLocation().getxAxisValue() + ", y axis = "+getCurrentLocation().getyAxisValue());
                        break;
                    }
                case 4:
                    if (X>=MAX){
                        System.out.println("Your animal cannot move right! It's next to the fence!");

                    }
                    else {
                        this.getCurrentLocation().setxAxisValue(X+1);
                        System.out.println("New position: x axis = "+getCurrentLocation().getxAxisValue() + ", y axis = "+getCurrentLocation().getyAxisValue());
                    }
            }
        }
    this.setStatusOfTurtle(TurtleStatus.HIDDEN);
    }

    /// ////////////////////////// ENUM SPECIFIC FOR TURTLE CLASS /////////////////////////

     public enum TurtleStatus {
         ACTIVE,
         HIDDEN;

         static TurtleStatus chooseTurtleStatus() {
             System.out.print("Choose status of the Turtle: [1] Hidden [2] Active. Choice: ");
             Scanner scanner = new Scanner(System.in);
             int statusChoice = scanner.nextInt();
             TurtleStatus statusOfATurtle = null;
             switch (statusChoice) {
                 case 1:
                     statusOfATurtle = TurtleStatus.HIDDEN;
                     break;
                 case 2:
                     statusOfATurtle = TurtleStatus.ACTIVE;
                     break;
             }
             return statusOfATurtle;
         }
     }
    ////////////////////// auto generated Getters & Setters /////////////////////////////////////////////


    public TurtleStatus getStatusOfTurtle() {
        return statusOfTurtle;
    }

    public void setStatusOfTurtle(TurtleStatus statusOfTurtle) {
        this.statusOfTurtle = statusOfTurtle;
    }
}
