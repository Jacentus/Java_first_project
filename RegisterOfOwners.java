package com.pl.jmotyka;

import java.util.ArrayList;

public class RegisterOfOwners {

    private static ArrayList <Owner> listOfOwners;

    public RegisterOfOwners() { }

    public void addOwnerToList(Owner ownerToBeAdded){
        getListOfOwners().add(ownerToBeAdded);
    }

    public boolean checkForSameOwner(Owner ownerToBeAdded, ArrayList<Owner> listToBeChecked){
        boolean hasBeenFound = false;
        for (int i = 0; i<listToBeChecked.size(); i++){
        if (listToBeChecked.get(i).equals(ownerToBeAdded)){
            hasBeenFound = true;
        }
    }
        return hasBeenFound;
}

    public void displayNameAndSurnameOfAllOwners(){
        for (int i = 0; i<getListOfOwners().size();i++){
            System.out.println("["+(i+1)+"]"+ listOfOwners.get(i).getName()+" "+listOfOwners.get(i).getSurname());
        }
    }

    ////////////////////// auto generated Getters & Setters /////////////////////////////////////////////

    public static ArrayList<Owner> getListOfOwners() {
        return listOfOwners;
    }

    public static void setListOfOwners(ArrayList<Owner> listOfOwners) {
        RegisterOfOwners.listOfOwners = listOfOwners;
    }
}
