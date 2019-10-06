package com.company;

import java.lang.String;
import java.util.Scanner;

public class Main {
    static int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static String letters[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",};

    //ввод числа
    public static void main(String[] args) {
//ввод числа
        try {
            System.out.println("Выберете вид калькулятора: 1.Калькултор римских чисел 2.Калькулятор арабских чисел");
            Scanner Kalkulator = new Scanner(System.in);
            int VidKalkulatora = Kalkulator.nextInt();
            if (VidKalkulatora != 1 && VidKalkulatora != 2) {
                throw new Exception("Введенное число должно равняться 1 или 2!!!");
            } else if (VidKalkulatora == 1) {
                RomanCalculate();
            } else if (VidKalkulatora == 2) {
                ArabicCalculate();
            }
        } catch (Exception ex) {
            System.out.println("Вы вввели неверное значение!");
        }

        System.out.println("Программа завершена");

    }



    public static String RomanCalculate() { //Класс, работающий с римскими числами
        int i = 0;
        int Peremennaia1 = 0;
        int Peremennaia2 = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        Scanner num = new Scanner(System.in);
        String EndOfProgram="Конец программы";

        //Вводим первое число
        System.out.println("Введите первое число (от I до X): ");
            String Variable1 = num.nextLine();
            for (i = 0; i < 10; i++) {
                if (letters[i].equals(Variable1)) {//проверяем входит ли строка "Variable1" в массив строк массива "letters"
                    Peremennaia1 = numbers[i];
                    flag1 = true;
                }
            }

            //Вводим второе число
        System.out.println("Введите второе число (от I до X): ");
            String Variable2 = num.nextLine();
            for (i = 0; i < 10; i++) {
                if (letters[i].equals(Variable2)) {
                    Peremennaia2 = numbers[i];
                    flag2 = true;
                }
            }

            if (flag1&&flag2) {
    System.out.println("Введите действие: +,-,*,/");
    String Operation = num.nextLine();
    if (Operation.equals("+")) {

        i = Peremennaia1 + Peremennaia2;
        if(i<=10&&i>=0) {
            System.out.println(letters[i - 1]);
            return letters[i - 1];
        }
        else System.out.println("Результат выходит за пределы");
    }
    if (Operation.equals("-")) {
        i = Peremennaia1 - Peremennaia2;
        if(i<=10&&i>=0) {
            System.out.println(letters[i - 1]);
            return letters[i - 1];
        }
        else System.out.println("Результат выходит за пределы");
    }
    if (Operation.equals("*")) {
        i = Peremennaia1 * Peremennaia2;
        if(i<=10&&i>=0) {
            System.out.println(letters[i - 1]);
            return letters[i - 1];
        }
        else System.out.println("Результат выходит за пределы");
    }
    if (Operation.equals("/")) {
        i = Peremennaia1 / Peremennaia2;
        if (i<=10&&i>=0) {
            System.out.println(letters[i - 1]);
            return letters[i];
        }
        else if (Peremennaia1<Peremennaia2)
        {
            System.out.println("Первое число больше второго!");
        }
        else System.out.println("Результат выходит за пределы");
    } else return EndOfProgram;
}
else
    System.out.println("Вы ввели неверное значение!");
    return EndOfProgram;

    }


    public static int ArabicCalculate() { //Класс, работающий с арабскими числами
        int Variable1 = 0, Variable2 = 0;
        Scanner num = new Scanner(System.in);

//Вводим первое число
        System.out.println("Введите первое число: ");
        try {
            Variable1 = num.nextInt();//Ввод значения

        } catch (NumberFormatException e) {
            System.err.println("Неверный формат!");
        }
//Вводим второе число
        System.out.println("Введите второе число: ");
        try {
            Variable2 = num.nextInt();//Ввод значения
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат!");
        }

try{
    Scanner ArifmeticAction=new Scanner(System.in);
        System.out.println("Введите действие: +,-,*,%");

            String Operation = ArifmeticAction.nextLine();
            if (Operation.equals("+")) {
                System.out.println(Variable1 + Variable2);
                return Variable1 + Variable2;
            }
            if (Operation.equals("-")) {
                System.out.println(Variable1 - Variable2);
                return Variable1 - Variable2;
            }
            if (Operation.equals("*")) {
                System.out.println(Variable1 * Variable2);
                return Variable1 * Variable2;
            }
            if (Operation.equals("/")) {
                System.out.println(Variable1/Variable2);
                return Variable1 / Variable2;
            } else {
                System.out.println("Вы ввели неверное значение!");
                return 0;
            }
        }
        catch (NumberFormatException e)
        {
            System.err.println("Неверный Формат!");
        }
System.out.println("Программа завершена");
return 0;
    }

}

