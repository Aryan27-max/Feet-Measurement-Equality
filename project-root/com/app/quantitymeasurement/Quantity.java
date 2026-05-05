package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends Unit> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }

        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    public boolean isEqual(Quantity<U> other) {
        double diff = Math.abs(this.toBase() - other.toBase());
        return diff < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?>)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        // Prevent cross-type comparison (Length vs Weight)
        if (!this.unit.getClass().equals(other.unit.getClass())) {
            return false;
        }

        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        long normalized = Math.round(toBase() / EPSILON);
        return Objects.hash(normalized, unit.getClass());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}