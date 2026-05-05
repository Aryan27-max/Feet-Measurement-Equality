package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Equal: " + q1.equals(q2));

        // ADD
        System.out.println("Add: " + q1.add(q2));

        // SUBTRACT
        System.out.println("Subtract: " + q1.subtract(q2));

        // COMPARISON
        System.out.println("Greater: " + q1.greaterThan(q2));
        System.out.println("Less: " + q1.lessThan(q2));
    }
}