package com.pl.jmotyka;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.exit;

public class GUI {

    public void displayMenu(){
        System.out.println("****************************MENU******************************");
        System.out.println("[1] Add an Owner   [2] Delete an Owner  [3] Enlist all Owners");
        System.out.println("[4] Add an Animal  [5] Delete an Animal [6] Enlist all Animals");
        System.out.println("[7] Move an Animal [8] Feed a Turtle    [9] Draw your Garden");
        System.out.println("[0] Exit program");
        System.out.println("**************************************************************");
        System.out.print("Select option: ");
    }

    public void navigateMenu(RegisterOfOwners myRegisterOfOwners, RegisterOfAnimals myRegisterOfAnimals){

        try {
            Scanner scanner = new Scanner(System.in);
            int ChoiceInMenu = scanner.nextInt();
            switch (ChoiceInMenu) {

                case 1:

                    System.out.println("**** ADDING A NEW OWNER ****");
                    Owner newOwner = new Owner();
                    newOwner.gatherOwnerInfo();
                    if (!myRegisterOfOwners.checkForSameOwner(newOwner, RegisterOfOwners.getListOfOwners())){
                    myRegisterOfOwners.addOwnerToList(newOwner);
                    }
                    else {
                        System.out.println("Owner already present in the registry!");
                    }
                    break;

                case 2:

                    if (RegisterOfOwners.getListOfOwners().size()!=0){
                    System.out.println("**** DELETING AN OWNER ****");
                    System.out.println("Who do you want to delete?");
                    myRegisterOfOwners.displayNameAndSurnameOfAllOwners();
                    System.out.print("Select number: ");
                    int choiceOfOwnerToDelete = scanner.nextInt();
                    RegisterOfOwners.getListOfOwners().remove(choiceOfOwnerToDelete-1);// -1 to adjust input variable (starts from 1) to array index
                    }
                    else System.out.println("There are no Owners to delete!");
                    break;

                case 3:

                    if (RegisterOfOwners.getListOfOwners().size()!=0){
                    System.out.println("**** ENLISTING ALL OWNERS ****");
                    for (int i = 0; i< RegisterOfOwners.getListOfOwners().size(); i++){
                        RegisterOfOwners.getListOfOwners().get(i).
                                displayFullOwnerInfo(RegisterOfOwners.getListOfOwners().get(i), myRegisterOfAnimals);
                    }}
                    else System.out.println("There are no Owners in the registry!");
                    break;

                case 4:

                    System.out.println("**** ADDING A NEW ANIMAL ****");
                    System.out.println("What kind of animal would you like to add?");
                    System.out.println("[1] Cat [2] Dog [3] Turtle");
                    int choiceOfAnimalToCreate = scanner.nextInt();
                    Animal newAnimal = null;
                    switch (choiceOfAnimalToCreate){
                        case 1:
                            newAnimal = new Cat();
                            newAnimal.gatherAnimalInfo();
                            break;
                        case 2:
                            newAnimal = new Dog();
                            newAnimal.gatherAnimalInfo();
                            break;
                        case 3:
                            newAnimal=new Turtle();
                            newAnimal.gatherAnimalInfo();
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    if (!myRegisterOfAnimals.checkForSameAnimal(newAnimal, RegisterOfAnimals.getListOfAnimals())){
                        myRegisterOfAnimals.addAnimalToList(newAnimal);
                    }
                    else {
                        System.out.println("Such Animal is already present in the registry!");
                    }
                    try {
                        if (!myRegisterOfOwners.checkForSameOwner(newAnimal.getOwner(), RegisterOfOwners.getListOfOwners())){
                            System.out.println("New Owner added to the registry!");
                            myRegisterOfOwners.addOwnerToList(newAnimal.getOwner());
                        }
                    } catch (NullPointerException e) {
                        System.out.println("This animal has no Owner!");
                    }
                    break;

                case 5:

                    if (RegisterOfAnimals.getListOfAnimals().size()!=0){
                        System.out.println("**** DELETING AN ANIMAL ****");
                        System.out.println("Which Animal do you want to delete?");
                        myRegisterOfAnimals.displayTypeAndNameOfAllAnimals();
                        System.out.print("Select number: ");
                        int choiceOfAnimalToDelete = scanner.nextInt();
                        RegisterOfAnimals.getListOfAnimals().remove(choiceOfAnimalToDelete-1); //-1 to adjust input variable (starts from 1) to array index
                    }
                    else System.out.println("There are no Animals to delete!");
                    break;

                case 6:

                    if (RegisterOfAnimals.getListOfAnimals().size()!=0){
                        System.out.println("**** ENLISTING ALL ANIMALS ****");
                        for (int i = 0; i< RegisterOfAnimals.getListOfAnimals().size(); i++){
                            RegisterOfAnimals.getListOfAnimals().get(i).displayFullAnimalInfo(RegisterOfAnimals.getListOfAnimals().get(i));
                        }}
                    else System.out.println("There are no Animals in the registry!");
                    break;

                case 7:

                    if (RegisterOfAnimals.getListOfAnimals().isEmpty()){
                        System.out.println("There are no Animals to move!");
                        break;
                    } else {
                        System.out.println("**** MOVING AN ANIMAL ****");
                        System.out.println("Which Animal do you want to move?");
                        myRegisterOfAnimals.displayTypeAndNameOfAllAnimals();
                        System.out.print("Select number: ");
                        int choiceOfAnimalToMove = scanner.nextInt();
                        RegisterOfAnimals.getListOfAnimals().get(choiceOfAnimalToMove-1).move(); //-1 to adjust input variable (starts from 1) to array index
                    }
                    break;

                case 8:
                    if (RegisterOfAnimals.getListOfAnimals().isEmpty()){
                        System.out.println("There are no animals in your garden!");
                        break;
                    } else if (myRegisterOfAnimals.checkForTurtles(RegisterOfAnimals.getListOfAnimals())){
                    System.out.println("**** IT'S FEEDING TIME ****");
                    System.out.println("Which Turtle looks hungry to you?");
                    Turtle turtleSearchedFor = myRegisterOfAnimals.chooseTurtleToFeed();
                    turtleSearchedFor.feedATurtle(RegisterOfAnimals.getListOfAnimals(), turtleSearchedFor);
                    } else {
                        System.out.println("There are no Turtles in your garden!");
                    }
                    break;

                case 9:

                    System.out.println("****** THAT'S HOW IT LOOKS ******");
                    GardenDrawer displayGarden = new GardenDrawer();
                    displayGarden.displayMyGarden(myRegisterOfAnimals);
                    break;

                case 0:

                    FileWriterForAnimalsInAGarden myFileWriter = new FileWriterForAnimalsInAGarden();
                    myFileWriter.saveAllToFile(RegisterOfOwners.getListOfOwners());
                    myFileWriter.saveAllToFile(RegisterOfAnimals.getListOfAnimals());
                    exit(0);
                    break;

            }
        } catch (InputMismatchException e){
            System.out.println("Input mismatch! Try again...");
            //e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("Wrong number! Try again...");
            //e.printStackTrace();
        } catch (IllegalStateException e){
            System.out.println("Oops, sth went wrong! Try again...");
            //e.printStackTrace();
        } catch (Exception e){
            //e.printStackTrace();
            System.out.println("Unknown error! Try again...");
        }
    }

        public void printWelcomeMessage(){
            System.out.println("                    **********************");
            System.out.println("                    Welcome in the garden!");
            System.out.println("                    **********************");
        }
    }


