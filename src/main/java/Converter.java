package main.java;

public class Converter {
    private static final float KM_IN_STEP = 0.00075F;
    private static final float KILOCAL_IN_STEP = 0.05F;

    public static int convertToKm(int steps) {
        return (int) (KM_IN_STEP * steps);
    }

    public static int convertStepsToKilocalories(int steps) {
        return (int) (KILOCAL_IN_STEP * steps);
    }
}