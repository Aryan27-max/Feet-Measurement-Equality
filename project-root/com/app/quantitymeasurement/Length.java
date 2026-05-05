package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001; // precision handling

    // ===== ENUM =====
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ===== CONSTRUCTOR =====
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // ===== CONVERT TO BASE UNIT (INCHES) =====
    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // ===== PRECISION SAFE COMPARISON =====
    public boolean compare(Length other) {
        double diff = Math.abs(this.toBaseUnit() - other.toBaseUnit());
        return diff < EPSILON;
    }

    // ===== EQUALS (STRICT CONTRACT) =====
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;              // reflexive
        if (obj == null) return false;             // null-safe
        if (this.getClass() != obj.getClass()) return false; // type-safe

        Length other = (Length) obj;
        return compare(other);
    }

    // ===== HASHCODE (IMPORTANT FOR UC9) =====
    @Override
    public int hashCode() {
        long normalized = Math.round(toBaseUnit() / EPSILON);
        return Long.hashCode(normalized);
    }
}