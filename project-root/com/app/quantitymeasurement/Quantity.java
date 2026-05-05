package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends Unit> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (value < 0)
            throw new IllegalArgumentException("Value cannot be negative");

        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    // ===== UC13 FEATURE 1: ADD =====
    public Quantity<U> add(Quantity<U> other) {
        double sum = this.toBase() + other.toBase();
        return new Quantity<>(unit.fromBase(sum), unit);
    }

    // ===== UC13 FEATURE 2: SUBTRACT =====
    public Quantity<U> subtract(Quantity<U> other) {
        double diff = this.toBase() - other.toBase();

        if (diff < 0)
            throw new IllegalArgumentException("Result cannot be negative");

        return new Quantity<>(unit.fromBase(diff), unit);
    }

    // ===== UC13 FEATURE 3: GREATER THAN =====
    public boolean greaterThan(Quantity<U> other) {
        return this.toBase() > other.toBase();
    }

    // ===== UC13 FEATURE 4: LESS THAN =====
    public boolean lessThan(Quantity<U> other) {
        return this.toBase() < other.toBase();
    }

    // ===== EQUALITY =====
    public boolean isEqual(Quantity<U> other) {
        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?>)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

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