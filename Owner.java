package com.pl.jmotyka;

import java.util.Objects;
import java.util.Scanner;

public class Owner implements Writable {

private String name;
private String secondName;
private String surname;
private SexEnum sex;
private int age;

    public Owner(String name, String secondName, String surname, SexEnum sex, int age) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    public Owner() {
    }

    public void gatherOwnerInfo(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Name: ");
    this.name = scanner.next();
    System.out.print("Second name: ");
    this.secondName = scanner.next();
    System.out.print("Surname: ");
    this.surname = scanner.next();
    this.setSex(SexEnum.chooseSex());
    System.out.print("Age: ");
    this.age = scanner.nextInt();
}

    public void displayFullOwnerInfo(Owner owner, RegisterOfAnimals registerOfAnimals){
        System.out.println("Name: " + owner.getName());
        System.out.println("Second name: " + owner.getSecondName());
        System.out.println("Surname: "+owner.getSurname());
        System.out.println("Sex: "+owner.getSex());
        System.out.println("Age: "+owner.getAge());
        System.out.print("Owner of the following animals: ");
        displayAnimalsOfCertainOwner(owner, registerOfAnimals);
        System.out.println("**************************************************************");
    }

    public void displayAnimalsOfCertainOwner(Owner owner, RegisterOfAnimals registerOfAnimals){
        /*int iterationNo = 0; moge sprawdzac przebieg petli i w zaleznosci od tego inaczej ksztaltowac wynik, np. dajac przecinek albo, gdy sie zwiekszy count tych samych, dopisac np. none    */
        for (int i = 0; i< RegisterOfAnimals.getListOfAnimals().size(); i++){
            if(RegisterOfAnimals.getListOfAnimals().get(i).getOwner().equals(owner)){
                System.out.print(RegisterOfAnimals.getListOfAnimals().get(i).displayYourType() + " " + RegisterOfAnimals.getListOfAnimals().get(i).getName()+ " ");
            }
        }
        System.out.println();
    }

    ////////////////////// Writable interface methods ////////////////////////////////////////////////////

    public String getFileNameToWriteTo(){
        return "owners.txt";
    }

    public String getDataToSave(){

        String result = "";

        result += name + "\n";
        result += secondName + "\n";
        result += surname + "\n";
        result += (sex == null ? "" : sex) + "\n";
        result += age + "\n";

        return result;
    }

    ////////////////////// .equals() and hashCode() override /////////////////////////////////////////////

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Owner){
            Owner own = (Owner)obj;
            if (own.name.equals(this.name)
                    && own.surname.equals(this.surname)
                    && Objects.equals(own.sex,this.sex)
                    && own.age == this.age)
                result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return age;
    }

    ////////////////////// auto generated Getters & Setters /////////////////////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
