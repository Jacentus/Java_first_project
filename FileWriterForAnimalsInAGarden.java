package com.pl.jmotyka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterForAnimalsInAGarden {

    public <T extends Writable> void saveAllToFile(ArrayList<T> listToBeSaved){
        if (listToBeSaved.isEmpty()){
            System.out.println("No data to save!"); return;}
        else {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(listToBeSaved.get(0).getFileNameToWriteTo(), false))){
            for (int i = 0; i < listToBeSaved.size(); i++) {
               bw.write(listToBeSaved.get(i).getDataToSave());
            }
        } catch (IOException e) {
            System.out.println("Error while opening file!");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Unknown error!");
            e.printStackTrace();
        } }
        }

}

/*    public void saveAllOwnersToFile(ArrayList<Owner> listToBeSaved, FileWriterForAnimalsInAGarden fileWriter) {
        if (listToBeSaved.isEmpty()) {
            System.out.println("No Owners to save!"); return;}
        else{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(listToBeSaved.get(0).getFileNameToWriteTo(), false))){
        for (int i = 0; i < listToBeSaved.size(); i++) {
            bw.write(listToBeSaved.get(i).getDataToSave());
        }
    } catch (IOException e) {
            System.out.println("Error while opening file!");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Unknown error!");
            e.printStackTrace();
        } }
    }

    public void saveAllAnimalsToFile(ArrayList<Animal> listToBeSaved, FileWriterForAnimalsInAGarden fileWriter) {
        if (listToBeSaved.isEmpty()) {
            System.out.println("No Animals to save!"); return;}
        else{
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(listToBeSaved.get(0).getFileNameToWriteTo(), false))){
                for (int i = 0; i < listToBeSaved.size(); i++) {
                    bw.write(listToBeSaved.get(i).getDataToSave());
                }
            } catch (IOException e) {
                System.out.println("Error while opening file!");
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("Unknown error!");
                e.printStackTrace();
            } }
    }*/