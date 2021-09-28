package com.pl.jmotyka;

import static com.pl.jmotyka.AnimalsInAGarden.*;

public class GardenDrawer {

    public void displayMyGarden(RegisterOfAnimals myAnimals) {
        int j = MAX;
        int width = MIN;
        if (RegisterOfAnimals.getListOfAnimals().isEmpty()) {
            System.out.println("No animals to draw! Exiting now...");
            return;
        }
        //////DRAWING OF THE UPPER FRAME STARTS
        System.out.print(" ");
        for (int k = MIN-1; k <= MAX; k++) { //k=MIN-1 as the frame extends the size of the Garden
            System.out.print("- ");
        }
        System.out.println();
        //////DRAWING OF THE UPPER FRAME ENDS
        while (j >= MIN) {
            System.out.print("| "); //left frame
            for (int k = MIN; k <= MAX; k++) {
                boolean isHere = false;
                int animalIndex = 0;
                int animalCount = 0;
                for (int i = 0; i < RegisterOfAnimals.getListOfAnimals().size(); i++) { //check location for animals
                    if (RegisterOfAnimals.getListOfAnimals().get(i).getCurrentLocation().getxAxisValue() == k &&
                            RegisterOfAnimals.getListOfAnimals().get(i).getCurrentLocation().getyAxisValue() == j) {
                        isHere = true; //informs next if statement whether or not an Animal is present on the given (k,j) location
                        animalIndex = i; //saves the index to be used in case one animal is on the spot
                        animalCount++; //count number of animals on the same spot
                    }
                }
                if (isHere) {
                    if (animalCount > 1) {
                        System.out.print(animalCount + " "); //if there is more than 1 animal at the same location print the number of animals at given location
                    } else {
                        String type = RegisterOfAnimals.getListOfAnimals().get(animalIndex).displayYourType(); //identify type of Animal and print appropriate letter
                        if (type.equals("Cat")) {
                            System.out.print("C ");
                        } else if (type.equals("Dog")) {
                            System.out.print("D ");
                        } else if (type.equals("Turtle")) {
                            System.out.print("T ");
                        }
                    }
                } else { //if no animal has been found, print default "*" sign
                    System.out.print("* ");
                }
            }
            System.out.print("| "); //right frame
            System.out.println();
            j--;
        }
        //DRAWING OF BOTTOM FRAME STARTS
        System.out.print(" ");
        for (int k = MIN-1; k <= MAX; k++) { //k=MIN-1 as the frame extends the size of the Garden
            System.out.print("- ");
        }
        System.out.println();
        //DRAWING OF BOTTOM FRAME ENDS
    }
}