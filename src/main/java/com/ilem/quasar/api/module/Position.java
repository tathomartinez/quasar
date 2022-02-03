package com.ilem.quasar.api.module;

public class Position {
    private double x;
    private double y;

    public Position(double x2, double y2) {
        this.x = x2;
        this.y = y2;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
