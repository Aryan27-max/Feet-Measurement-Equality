package com.apps.quantitymeasurement;

public class QuantityMeasurementService {

    public static <U extends Unit> boolean compare(
            double v1, U u1,
            double v2, U u2) {

        Quantity<U> q1 = new Quantity<>(v1, u1);
        Quantity<U> q2 = new Quantity<>(v2, u2);

        return q1.equals(q2);
    }
}