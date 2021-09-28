package com.pl.jmotyka;

import java.util.Scanner;

import static com.pl.jmotyka.AnimalsInAGarden.*;

public abstract class Animal implements Movable, Writable {

    private String name;
    private SexEnum sex;
    private int age;
    private Location currentLocation;
    private Owner owner;

    public Animal(String name, SexEnum sex, int age, Location currentLocation, Owner owner) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.currentLocation = currentLocation;
        this.owner = owner;
    }

    public Animal(){
    }

    public void gatherAnimalInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = scanner.next();
        this.setSex(SexEnum.chooseSex());
        System.out.println("Age: ");
        this.age = scanner.nextInt();
        System.out.println("Provide info about the Owner. Name:");
        String ownersName = scanner.next();
        System.out.println("Second name: ");
        String ownersSecondName = scanner.next();
        System.out.println("Surname: ");
        String ownersSurname = scanner.next();
        SexEnum ownersSex = SexEnum.chooseSex();
        System.out.println("Owners age: ");
        int ownersAge = scanner.nextInt();
        Owner newOwner = new Owner(ownersName, ownersSecondName, ownersSurname, ownersSex, ownersAge);
        this.owner = newOwner;
    }

//////////////////////////// .equals() and hashCode() override /////////////////////////////////////////////

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public abstract boolean equals(Object obj);

///////////////////////////// abstract methods //////////////////////////////////////////

    public abstract String displayYourType();

    public abstract void displayFullAnimalInfo(Animal animal);

/////////////////////////////////// Writable interface methods /////////////////////////////////////

    public String getFileNameToWriteTo(){
        return "animals.txt";
    }

    public abstract String getDataToSave();

/////////////////////////////////// Movable interface methods /////////////////////////////////////

    @Override
    public void move(){
        System.out.println("Which direction? Select: [1] UP [2] DOWN [3] LEFT [4] RIGHT");
        Scanner scanner = new Scanner(System.in);
        int choiceDirection = scanner.nextInt();
        int X = this.getCurrentLocation().getxAxisValue();
        int Y = this.getCurrentLocation().getyAxisValue();
        System.out.println("Current position: x axis = "+X + ", y axis = "+Y);
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

/////////////////////////// auto generated Getters & Setters /////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
