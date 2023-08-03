package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MonthData {
    private final int countDaysInMonth = 30;
    private int[] days = new int[countDaysInMonth];

    public int[] getDays() {
        return days;
    }

    public String printDaysAndStepsFromMonth() {
        return Arrays.stream(days).mapToObj(day -> day + " ").collect(Collectors.joining("", "", ""));
    }

    public int sumStepsFromMonth() {
        return Arrays.stream(days).sum();
    }

    public int maxSteps() {
        return Arrays.stream(days).max().orElse(0);
    }

    public int getBestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (finalSeries < currentSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    public int getAvgValueStepsPerMonth() {
        return sumStepsFromMonth() / countDaysInMonth;
    }
}