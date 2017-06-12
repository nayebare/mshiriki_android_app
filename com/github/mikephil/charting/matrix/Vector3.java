package com.github.mikephil.charting.matrix;

import com.google.android.gms.cast.TextTrackStyle;

public final class Vector3 {
    public static final Vector3 UNIT_X;
    public static final Vector3 UNIT_Y;
    public static final Vector3 UNIT_Z;
    public static final Vector3 ZERO;
    public float f13x;
    public float f14y;
    public float f15z;

    static {
        ZERO = new Vector3(0.0f, 0.0f, 0.0f);
        UNIT_X = new Vector3(TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f, 0.0f);
        UNIT_Y = new Vector3(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f);
        UNIT_Z = new Vector3(0.0f, 0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public Vector3(float[] array) {
        set(array[0], array[1], array[2]);
    }

    public Vector3(float xValue, float yValue, float zValue) {
        set(xValue, yValue, zValue);
    }

    public Vector3(Vector3 other) {
        set(other);
    }

    public final void add(Vector3 other) {
        this.f13x += other.f13x;
        this.f14y += other.f14y;
        this.f15z += other.f15z;
    }

    public final void add(float otherX, float otherY, float otherZ) {
        this.f13x += otherX;
        this.f14y += otherY;
        this.f15z += otherZ;
    }

    public final void subtract(Vector3 other) {
        this.f13x -= other.f13x;
        this.f14y -= other.f14y;
        this.f15z -= other.f15z;
    }

    public final void subtractMultiple(Vector3 other, float multiplicator) {
        this.f13x -= other.f13x * multiplicator;
        this.f14y -= other.f14y * multiplicator;
        this.f15z -= other.f15z * multiplicator;
    }

    public final void multiply(float magnitude) {
        this.f13x *= magnitude;
        this.f14y *= magnitude;
        this.f15z *= magnitude;
    }

    public final void multiply(Vector3 other) {
        this.f13x *= other.f13x;
        this.f14y *= other.f14y;
        this.f15z *= other.f15z;
    }

    public final void divide(float magnitude) {
        if (magnitude != 0.0f) {
            this.f13x /= magnitude;
            this.f14y /= magnitude;
            this.f15z /= magnitude;
        }
    }

    public final void set(Vector3 other) {
        this.f13x = other.f13x;
        this.f14y = other.f14y;
        this.f15z = other.f15z;
    }

    public final void set(float xValue, float yValue, float zValue) {
        this.f13x = xValue;
        this.f14y = yValue;
        this.f15z = zValue;
    }

    public final float dot(Vector3 other) {
        return ((this.f13x * other.f13x) + (this.f14y * other.f14y)) + (this.f15z * other.f15z);
    }

    public final Vector3 cross(Vector3 other) {
        return new Vector3((this.f14y * other.f15z) - (this.f15z * other.f14y), (this.f15z * other.f13x) - (this.f13x * other.f15z), (this.f13x * other.f14y) - (this.f14y * other.f13x));
    }

    public final float length() {
        return (float) Math.sqrt((double) length2());
    }

    public final float length2() {
        return ((this.f13x * this.f13x) + (this.f14y * this.f14y)) + (this.f15z * this.f15z);
    }

    public final float distance2(Vector3 other) {
        float dx = this.f13x - other.f13x;
        float dy = this.f14y - other.f14y;
        float dz = this.f15z - other.f15z;
        return ((dx * dx) + (dy * dy)) + (dz * dz);
    }

    public final float normalize() {
        float magnitude = length();
        if (magnitude != 0.0f) {
            this.f13x /= magnitude;
            this.f14y /= magnitude;
            this.f15z /= magnitude;
        }
        return magnitude;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public final boolean pointsInSameDirection(Vector3 other) {
        return dot(other) > 0.0f;
    }
}
