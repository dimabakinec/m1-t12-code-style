package CodeStyle.src;

import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return calculateRounding(pay, 2);
    }

    double calculateSimplePercent(double amount, double doubleYearRate, int depositPeriod) {
        return calculateRounding(amount + amount * doubleYearRate * depositPeriod, 2);
    }

    double calculateRounding(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void doImportantJob() {
        int period, action;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scan.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scan.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scan.nextInt();
        double accumulation = 0;
        if (action == 1) accumulation = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            accumulation = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + accumulation);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}
