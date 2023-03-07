package ru.netology;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        int difference = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода");
                    String moneySpend = scanner.nextLine();
                    int moneySp = Integer.parseInt(moneySpend);
                    spendings += moneySp;
                    break;
                case 3:
                    int taxE = Calculate.taxEarnings(earnings);
                    int taxEMS = Calculate.taxEarningsMinusSpendings(earnings, spendings);
                    if (taxE < taxEMS) {
                        difference = taxEMS - taxE;
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxE + " рублей");
                        System.out.println("Налог на другой системе: " + taxEMS + " рублей");
                        System.out.println("экономия: " + difference + " рублей");
                    } else if (taxE > taxEMS) {
                        difference = taxE - taxEMS;
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEMS + " рублей");
                        System.out.println("Налог на другой системе: " + taxE + " рублей");
                        System.out.println("экономия: " + difference + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}

