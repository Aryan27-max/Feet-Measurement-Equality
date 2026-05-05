package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testLengthEquality() {
        assertTrue(QuantityMeasurementService.compare(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES));
    }

    @Test
    public void testWeightEquality() {
        assertTrue(QuantityMeasurementService.compare(
                1.0, WeightUnit.KILOGRAM,
                1000.0, WeightUnit.GRAM));
    }

    @Test
    public void testCrossTypeInequality() {
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(l.equals(w));
    }

    @Test
    public void testNegativeValue() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(-1.0, LengthUnit.FEET));
    }

    @Test
    public void testReflexive() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertTrue(q.equals(q));
    }
}