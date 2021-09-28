package com.pl.jmotyka;

import static com.pl.jmotyka.AnimalsInAGarden.*;

public class Location {

    private int xAxisValue;
    private int yAxisValue;

    public Location(){
        this.xAxisValue = MIN;
        this.yAxisValue = MAX;
    }

    public Location(int xAxisValue, int yAxisValue) {
        this.xAxisValue = xAxisValue;
        this.yAxisValue = yAxisValue;
    }

    ////////////////////// auto generated Getters & Setters /////////////////////////////////////////////

    public int getxAxisValue() {
        return xAxisValue;
    }

    public void setxAxisValue(int xAxisValue) {
        this.xAxisValue = xAxisValue;
    }

    public int getyAxisValue() {
        return yAxisValue;
    }

    public void setyAxisValue(int yAxisValue) {
        this.yAxisValue = yAxisValue;
    }
}
