/*
в одной из статей Практикума читал что работа сдаваемая на проверку не должна иметь варнингов...
точно не вспомню где. Вроде на Яндекс диске в требованиях к коду.
Варианты исправления варнингов предложил в комментах внутри методов=)
 */

import java.util.Scanner;

public class DepositCalculator {
    /* Переменную yearRate желательно вынести как константу метода, т.к. при вызове метода передается невычисляемое
    значение:
    if (action == 1) {                                        здесь
            finalAmount = calculateSimplePercent(depositAmount,0.06, depositPeriod);
     */
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double payoutSum = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundNumbers(payoutSum,2);
    } // в идеале методы должны быть разделены одной строкой
    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return roundNumbers(depositAmount + depositAmount * yearRate * depositPeriod,2);
    } // в идеале методы должны быть разделены одной строкой
    double roundNumbers(double value, int places) { // переменную places можно убрать - она не меняется
        double ScaLe = Math.pow(10, places); // либо здесь меняем ее на 2, либо можно вынести константой класса
        return Math.round(value * ScaLe) / ScaLe;
    }

    void runDepositCalculator() { // в этом методе все отлично поделено на группы! =)
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
