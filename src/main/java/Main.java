package main.java;

import java.util.Scanner;

public class Main {
    private static final String MENU = "Введите комаду для продолжения:\n" +
            "0 - Выйти из приложения\n" +
            "1 - Ввести количество шагов за определённый день\n" +
            "2 - Изменить цель по количеству шагов в день\n" +
            "3 - Напечатать статистику за определённый месяц\n";
    private static final String MESSAGE_FOR_UNKNOWN_COMMAND = "Введена неизвестная команда, для выхода из приложения введите 0\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        int i;
        while (true) {
            System.out.print(MENU);
            i = Integer.parseInt(scanner.nextLine());
            switch (i) {
                case 0:
                    return;
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                default:
                    System.out.print(MESSAGE_FOR_UNKNOWN_COMMAND);
            }
        }
    }
}