package com.github.mikephil.charting.utils;

public class PointD {
    public double f20x;
    public double f21y;

    public PointD(double x, double y) {
        this.f20x = x;
        this.f21y = y;
    }

    public String toString() {
        return "PointD, x: " + this.f20x + ", y: " + this.f21y;
    }
}
