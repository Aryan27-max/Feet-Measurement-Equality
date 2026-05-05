package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void validEquality() {
        assertTrue(QuantityMeasurementService.compare(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES));
    }

    @Test
    public void invalidNegativeValue() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(-1.0, LengthUnit.FEET));
    }

    @Test
    public void nullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null));
    }

    @Test
    public void inequality() {
        assertFalse(QuantityMeasurementService.compare(
                2.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES));
    }

    @Test
    public void reflexiveProperty() {
        Length l = new Length(1.0, LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void symmetricProperty() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(12.0, LengthUnit.INCHES);

        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }
}