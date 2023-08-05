package main.java;

import java.util.Scanner;

public class StepTracker {
    private MonthData[] monthToData = new MonthData[12];
    private final Scanner scanner;
    private int goalByStepsPerDay = 10000;

    private static final String MESSAGE_INPUT_MONTH_AND_DAY = "Введите данные через пробел: номер месяца (1-январь), номер дня месяца, количество шагов";
    private static final String MESSAGE_GET_MONTH_STATISTICS = "Введите номер месяца для получения статистики:";
    private static final String MESSAGE_CHANGE_STEP_GOAL = "Введите новое значение цели(количество шагов):";
    private static final String MESSAGE_ERROR_COUNT_MONTH = "Номер вводимого месяца должен быть от 1 до 12 включительно!";
    private static final String MESSAGE_ERROR_COUNT_DAYS = "Номер вводимого дня должен быть от 1 до 30 включительно!";
    private static final String MESSAGE_ERROR_COUNT_STEP = "Количество шагов должно быть положительным числом!";
    private static final String[] STATISTIC_MESSAGE = {
            "Количество пройденных шагов по дням: ",
            "Общее количество шагов за месяц: ",
            "Максимальное пройденное количество шагов в месяце: ",
            "Среднее количество шагов: ",
            "Пройденная дистанция (в км): ",
            "Количество сожжённых килокалорий: ",
            "Лучшая серия: "
    };

    public MonthData[] getMonthToData() {
        return monthToData;
    }

    public void changeStepGoal() {
        System.out.println(MESSAGE_CHANGE_STEP_GOAL);
        int goalByStepsPerDay = Integer.parseInt(scanner.nextLine()) - 1;
        if (goalByStepsPerDay < 0) System.out.println(MESSAGE_ERROR_COUNT_STEP);
        else {
            this.goalByStepsPerDay = goalByStepsPerDay;
        }
    }

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println(MESSAGE_INPUT_MONTH_AND_DAY);
        String[] numbers = scanner.nextLine().split(" ");
        int numberMonth = Integer.parseInt(numbers[0]);
        int numberDay = Integer.parseInt(numbers[1]);
        int countSteps = Integer.parseInt(numbers[2]);
        if (numberMonth < 1 || numberMonth > 12) {
            System.out.println(MESSAGE_ERROR_COUNT_MONTH);
        } else {
            if (numberDay < 1 || numberDay > 30) {
                System.out.println(MESSAGE_ERROR_COUNT_DAYS);
            } else {
                if (countSteps <= 0) {
                    System.out.println(MESSAGE_ERROR_COUNT_STEP);
                } else monthToData[numberMonth - 1].getDays()[numberDay - 1] = countSteps;
            }
        }
    }

    void printStatistic() {
        System.out.print(MESSAGE_GET_MONTH_STATISTICS);
        int month = Integer.parseInt(scanner.nextLine()) - 1;
        MonthData monthToDatum = monthToData[month];
        System.out.println(STATISTIC_MESSAGE[0] + monthToDatum.printDaysAndStepsFromMonth());
        System.out.println(STATISTIC_MESSAGE[1] + monthToDatum.sumStepsFromMonth());
        System.out.println(STATISTIC_MESSAGE[2] + monthToDatum.maxSteps());
        System.out.println(STATISTIC_MESSAGE[3] + monthToDatum.getAvgValueStepsPerMonth());
        System.out.println(STATISTIC_MESSAGE[4] + Converter.convertToKm(monthToDatum.sumStepsFromMonth()));
        System.out.println(STATISTIC_MESSAGE[5] + Converter.convertStepsToKilocalories(monthToDatum.sumStepsFromMonth()));
        System.out.println(STATISTIC_MESSAGE[6] + monthToDatum.getBestSeries(goalByStepsPerDay));
    }
}