package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        // ===== UC11: VALUE VALIDATION =====
        if (value < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }

        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toBase(value);
    }

    public boolean isEqual(Length other) {
        double diff = Math.abs(this.toBaseUnit() - other.toBaseUnit());
        return diff < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        long normalized = Math.round(toBaseUnit() / EPSILON);
        return Objects.hash(normalized);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}