package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println(QuantityMeasurementService.compare(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES)); // true

        System.out.println(QuantityMeasurementService.compare(
                1.0, LengthUnit.YARDS,
                3.0, LengthUnit.FEET)); // true

        System.out.println(QuantityMeasurementService.compare(
                100.0, LengthUnit.CENTIMETERS,
                39.3701, LengthUnit.INCHES)); // true

        // ===== UC11 TEST (INVALID VALUE) =====
        try {
            Length invalid = new Length(-5.0, LengthUnit.FEET);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}