package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ===== LENGTH =====
        System.out.println(
                QuantityMeasurementService.compare(
                        1.0, LengthUnit.FEET,
                        12.0, LengthUnit.INCHES)); // true

        System.out.println(
                QuantityMeasurementService.compare(
                        1.0, LengthUnit.YARDS,
                        36.0, LengthUnit.INCHES)); // true

        // ===== WEIGHT =====
        System.out.println(
                QuantityMeasurementService.compare(
                        1.0, WeightUnit.KILOGRAM,
                        1000.0, WeightUnit.GRAM)); // true

        System.out.println(
                QuantityMeasurementService.compare(
                        1.0, WeightUnit.KILOGRAM,
                        2.0, WeightUnit.POUND)); // false

        // ===== INVALID CROSS TYPE =====
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        System.out.println(length.equals(weight)); // false
    }
}