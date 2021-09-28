package com.pl.jmotyka;

import java.util.Objects;
import java.util.Scanner;

public class Dog extends Animal {

    private String breed;

    public Dog(String name, SexEnum sex, int age, Location currentLocation, Owner owner, String breed) {
        super(name, sex, age, currentLocation, owner);
        this.breed = breed;
    }

    public Dog(){
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
        result += breed + "\n";

        return result;
    }

////////////////////////////// Animal class methods //////////////////////////////////////////////////////////////

    @Override
    public void gatherAnimalInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        this.setName(scanner.next());
        this.setSex(SexEnum.chooseSex());
        System.out.print("Age: ");
        this.setAge(scanner.nextInt());
        System.out.print("Breed: ");
        this.setBreed(scanner.next());
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
        this.setOwner(newOwner);
        this.setCurrentLocation(new Location());
    }

    @Override
    public String displayYourType(){
        return "Dog";
    }

    public void displayFullAnimalInfo(Animal animal){
        System.out.println("Name: " + animal.getName());
        System.out.println("Type: "+ animal.displayYourType());
        System.out.println("Breed: " +((Dog)animal).getBreed());
        System.out.println("Sex: "+ animal.getSex());
        System.out.println("Age: "+ animal.getAge());
        System.out.println("Owner: " + animal.getOwner().getName() + " "+animal.getOwner().getSurname());
        System.out.println("Located at: x="+animal.getCurrentLocation().getxAxisValue()+", y="+animal.getCurrentLocation().getyAxisValue());
        System.out.println("**************************************************************");
    }

    ////////////////////// .equals() override /////////////////////////////////////////////
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Dog){
            Dog dog = (Dog)obj;
            if (dog.getName().equals(this.getName())
                    && Objects.equals(dog.getSex(),this.getSex())
                    && dog.getAge() == this.getAge()
                    && dog.getOwner().equals(this.getOwner())
                    && dog.getBreed().equals(this.getBreed()))
                result = true;
        }
        return result;
    }

    ////////////////////// auto generated Getters & Setters /////////////////////////////////////////////

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
