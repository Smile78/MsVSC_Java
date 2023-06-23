package HW05;

/*

Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Задание

Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

Пример меню:
1) Добавить контакт
2) Вывести всех
3) Выход

Иванов 123432
Иванов 546457
Иванов 788354

Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], Петров:[4325, 45674]}

*/

import HW01.HW01_04_xX_chisla.InpSngltone;

import java.util.*;

public class GbJavaApiSemHW05 {

    // public static Map tlfn_Book = new HashMap<>();
    public static Map<String, ArrayList<String>> tlfn_Book = new HashMap<>();

    public static void main(String[] args) {

        method_1_hw_middle_outer();

    }

    private static void method_1_hw_middle_outer() {

        boolean stop = false;

        while (!stop) {

            System.out.println("\n--------------TELEPHONE BOOK-----------------");

            // String str0mtd = inp_Method("Введите имя и цифры ... \nтипа: Андрей 3458734
            // \nили exit");
            String str0mtd = inp_Method_part1("1 - Добавить контакт 2 - Вывести всех ...\nили exit");

            String[] str2 = { "" };
            if (str0mtd.equalsIgnoreCase("exit")) {
                stop = true;
            } else {
                str2 = str0mtd.trim().toLowerCase().split(" ");

                if (str2[0].matches("[0-9]{1}")) {
                    switch (Integer.parseInt(str2[0])) {
                        case 1 -> {
                            System.out.println("--- Операция: 1 ---");
                            inputTlfnNumber();
                        }
                        case 2 -> {
                            System.out.println("--- Операция: 2 ---");
                            outputAll();
                        }
                        default -> System.out.println("Такого номера операции пока нет");
                    }
                } else
                    System.out.println("1- Ошибка---Некорректный ввод ---");
            }

        }

    }

    private static void outputAll() {
        if (tlfn_Book.size() > 0) {
            System.out.println("----------Вывод Всей Телефонной книги------------");
            for (Map.Entry<String,ArrayList<String>> mp1KV : tlfn_Book.entrySet()) {
                System.out.println("Контакт:\n" + mp1KV.getKey());
                ArrayList<String> NmbrsList = tlfn_Book.get(mp1KV.getKey());
                if (NmbrsList.size() == 0) {
                    System.out.println("Номер телефона пока не добавлен");
                } else if (NmbrsList.size() == 1) {
                    System.out.println("Номер телефона:\n" + NmbrsList.get(0));

                } else {
                    System.out.println("Номера телефонов");
                    NmbrsList.stream().forEach(System.out::println);
                }
            }
            System.out.println("---------- Конец Телефонной книги ------------");
        } else
            System.out.println("---------- Книга не заполнена ----------");

    }

    // T0D0 лучше сделать инпут метод с возвратом массива Аргс а потом уже чето
    // делать
    private static void inputTlfnNumber() {
        String[] contact1Numbr = inp_Method_part2("Введите имя и цифры чз пробел, вида\nАndrey 89211234567 - beCAsuE NO ENG in VSC");

        try {
            // for (Map.Entry<String,ArrayList<Integer>> cntcts: tlfn_Book ){
            ArrayList<String> oldNmbrsList = tlfn_Book.get(contact1Numbr[0]);
            if (tlfn_Book.containsKey(contact1Numbr[0])) {

                if (oldNmbrsList.contains(contact1Numbr[1])) {
                    System.out.println("Уже есть такой номер у данного контакта");
                } else {
                    // if(contact1Numbr[1].length()>0&contact1Numbr[1].matches("[0-9]")){
                    if (contact1Numbr[1].length() > 1) {
                        oldNmbrsList.add(contact1Numbr[1]);
                        tlfn_Book.put(contact1Numbr[0], oldNmbrsList);
                        System.out.println("Добавили " + contact1Numbr[0] + " " + contact1Numbr[1]);
                        System.out.println("jst 4 inf... Теперь у " + contact1Numbr[0] + " такой список номеров:");
                        tlfn_Book.get(contact1Numbr[0]).stream().forEach(System.out::println);
                    } else
                        System.out.println("22 Ошибка");

                }
            } else {
                // if(contact1Numbr[1].length()>0&contact1Numbr[1].matches("[0-9]")){
                if (contact1Numbr[1].length() > 0) {

                    ArrayList<String> newNmbrsList = new ArrayList<>();
                    newNmbrsList.add(contact1Numbr[1]);
                    tlfn_Book.put(contact1Numbr[0], newNmbrsList);
                    System.out.println("Добавили " + contact1Numbr[0] + " " + contact1Numbr[1]);
                    System.out.println("Терь " + contact1Numbr[0] + " такой список:");
                    tlfn_Book.get(contact1Numbr[0]).stream().forEach(System.out::println);
                    // T0D0 добавить ввод пустого номера
                } else
                    System.out.println("33 - Ошибка   - некорректиное заполнение -");

            }

        } catch (Exception x) {
            System.out.println(x);
        }

    }

    private static String[] inp_Method_part2(String str0) {

        String[] str2out = { "unknown", "0" }; // типизация експт и 0трбл начало

        // "Введите имя и цифры чз пробел, вида\nАндрей 89211234567"
        // try {

        boolean stop = false;
        while (!stop) {

            String str0mtd = inp_Method_part1(str0);

            String[] str2 = str0mtd.trim().toLowerCase().split(" ");

            String nameStr = "";
            // long tlfn_Nmbr = Long.parseLong(str2[1]);
            String tlfn_Nmbr = "";

            if (str2[0].length() < 1 | str2[0].isEmpty() | str2[0] == null) {
                System.out.println("44 - Ошибка   - некорректиное заполнение имени ");
            } else if (str2.length > 1) {
                // if (str2[1].matches("[0-9]")) {
                try {
                    nameStr = str2[0];
                    // long tlfn_Nmbr = Long.parseLong(str2[1]);

                    if (str2[1].matches("[0-9]{1,11}")) {
                        tlfn_Nmbr = str2[1];
                        System.out.println("inp met2 name nd nmbr: " + nameStr + " " + tlfn_Nmbr);
                        stop = true;
                    } else {
                        System.out.println("55 - Ошибка   - некорректиное заполнение номера телефона");

                    }

                } catch (Exception x) {
                    System.out.println(x);
                }
                // } else {
                // System.out.println("88");
                // System.out.println("Некоректный номер тлфн. надо тольок цифры 0-9");
                // }

            } else {
                System.out.println("66 - Ошибка   - unknown");

            }

            // t0d0 проверку на ввод?
            // if(nameStr.matches([]))

            str2out[0] = nameStr;
            // str2out[1]= String.valueOf(tlfn_Nmbr);
            str2out[1] = tlfn_Nmbr;

            // } catch (Exception x){
            // System.out.println(x);
            // }
        }

        return str2out;
    }

    private static String inp_Method_part1(String prnt) { // static?!
        InpSngltone inpSng = InpSngltone.getInstance();

        return inpSng.inp_Method(prnt);
    }

}// class
