package com.pl.jmotyka;

import java.util.ArrayList;

public class AnimalsInAGarden {

    public static final int MAX=14;
    public static final int MIN=1;

    public void startMyGarden(){

        GUI myMenu = new GUI();
        myMenu.printWelcomeMessage();

        FileReaderForAnimalsInAGarden myFileReader = new FileReaderForAnimalsInAGarden();

        RegisterOfOwners myRegisterOfOwners = new RegisterOfOwners();
        RegisterOfAnimals myRegisterOfAnimals = new RegisterOfAnimals();

        ArrayList myListOfOwners = myFileReader.readAllOwnersFromFile();
        RegisterOfOwners.setListOfOwners(myListOfOwners);

        ArrayList myListOfAnimals = myFileReader.readAllAnimalsFromFile(myRegisterOfOwners);
        RegisterOfAnimals.setListOfAnimals(myListOfAnimals);

        while (true){

            myMenu.displayMenu();
            myMenu.navigateMenu(myRegisterOfOwners, myRegisterOfAnimals);

        }
    }
}
