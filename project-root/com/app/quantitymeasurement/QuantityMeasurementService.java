package com.apps.quantitymeasurement;

public class QuantityMeasurementService {

    public static boolean compare(double v1, LengthUnit u1,
                                  double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }
}