package com.apps.quantitymeasurement;

public class QuantityMeasurementService {

    public static <U extends Unit> boolean compare(
            double v1, U u1,
            double v2, U u2) {

        return new Quantity<>(v1, u1)
                .equals(new Quantity<>(v2, u2));
    }
}