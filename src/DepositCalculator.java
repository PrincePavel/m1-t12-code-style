import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double payoutSum = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundNumbers(payoutSum,2);
    }
    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return roundNumbers(depositAmount + depositAmount * yearRate * depositPeriod,2);
    }
    double roundNumbers(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void runDepositCalculator() {
        double finalAmount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        if (action == 1) {
            finalAmount = calculateSimplePercent(depositAmount,0.06, depositPeriod);
        } else if (action == 2) {
            finalAmount = calculateComplexPercent(depositAmount,0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за "
                + depositPeriod + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().runDepositCalculator();
    }
}
