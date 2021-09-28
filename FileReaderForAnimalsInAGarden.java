package com.pl.jmotyka;

import java.io.*;
import java.util.ArrayList;

public class FileReaderForAnimalsInAGarden {

    public ArrayList<Animal> readAllAnimalsFromFile(RegisterOfOwners myRegisterOfOwners){

        ArrayList listOfAnimals = new ArrayList<Animal>();
        String filePath = "animals.txt";
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null){
                String type = line;
                String animalName = br.readLine();
                String animalSexString = br.readLine();
                SexEnum animalSex = null;
                if (animalSexString.equals("MALE")){
                    animalSex = SexEnum.MALE;
                } else if (animalSexString.equals("FEMALE")) {
                    animalSex = SexEnum.FEMALE;}
                int animalAge = Integer.parseInt(br.readLine());
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());
                Location animalLocation = new Location();
                animalLocation.setxAxisValue(x);
                animalLocation.setyAxisValue(y);
                String ownerName = br.readLine();
                String ownersSecondName = br.readLine();
                String ownerSurname = br.readLine();
                String ownerSexString = br.readLine();
                SexEnum ownerSex = null;
                if (ownerSexString.equals("MALE")){
                    ownerSex = SexEnum.MALE;
                } else if (ownerSexString.equals("FEMALE")) {
                    ownerSex = SexEnum.FEMALE;}
                int ownerAge = Integer.parseInt(br.readLine());
                Owner newOwner = new Owner(ownerName, ownersSecondName, ownerSurname, ownerSex, ownerAge);

                if (!myRegisterOfOwners.checkForSameOwner(newOwner, RegisterOfOwners.getListOfOwners())){
                    RegisterOfOwners.getListOfOwners().add(newOwner);
                }
                String breedOrStatus = br.readLine();
                Turtle.TurtleStatus animalStatus = null;
                if (breedOrStatus.equals("HIDDEN")){
                    animalStatus = Turtle.TurtleStatus.HIDDEN;
                } else if (breedOrStatus.equals("ACTIVE")){
                    animalStatus = Turtle.TurtleStatus.ACTIVE;
                }
                if (type.equals("Cat")) {
                    Cat newCat = new Cat(animalName, animalSex, animalAge, animalLocation, newOwner, breedOrStatus);
                    listOfAnimals.add(newCat);
                }
                else if (type.equals("Dog")){
                    Dog newDog = new Dog(animalName, animalSex, animalAge, animalLocation, newOwner, breedOrStatus);
                    listOfAnimals.add(newDog);
                }
                else if (type.equals("Turtle")){
                    Turtle newTurtle = new Turtle(animalName, animalSex, animalAge, animalLocation, newOwner, animalStatus);
                    listOfAnimals.add(newTurtle);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();}

        return listOfAnimals;
    }

    public ArrayList<Owner> readAllOwnersFromFile(){

        ArrayList myListOfOwners = new ArrayList<Owner>();
        String filePath = "owners.txt";

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null){
                String name = line;
                String secondName = br.readLine();
                String surname = br.readLine();
                String sexString = br.readLine();
                SexEnum sex = null;
                if (sexString.equals("MALE")){
                    sex = SexEnum.MALE;
                } else if (sexString.equals("FEMALE")) {
                    sex = SexEnum.FEMALE;}

                int age = Integer.parseInt(br.readLine());
                Owner newOwner = new Owner(name, secondName, surname, sex, age);
                myListOfOwners.add(newOwner);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();}
        return myListOfOwners;
    }
}