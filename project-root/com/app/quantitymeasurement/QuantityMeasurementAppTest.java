package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.add(q2).equals(new Quantity<>(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testSubtraction() {
        Quantity<LengthUnit> q1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.subtract(q2).equals(new Quantity<>(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testGreaterThan() {
        Quantity<LengthUnit> q1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.greaterThan(q2));
    }

    @Test
    public void testLessThan() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(24.0, LengthUnit.INCHES);

        assertTrue(q1.lessThan(q2));
    }

    @Test
    public void testNegativeResult() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(24.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> q1.subtract(q2));
    }
}