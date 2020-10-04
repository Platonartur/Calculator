//Калькулятор римских и арабских чисел 
package com.company;

import java.lang.String;
import java.util.Scanner;
 
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static String letters[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",};

    public static void main(String[] args) 
    {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операции: " + result);
    }
 
    public static int getInt()
    {
        System.out.println("Введите число: ");
        int num;
        if(scanner.hasNextInt())
        {
            num = scanner.nextInt();
        } 
        else 
        {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }
 
    public static char getOperation()
    {
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext())
        {
            operation = scanner.next().charAt(0);
        } 
        else 
        {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }
 
    public static int calc(int num1, int num2, char operation) //калькулятор арабских чисел
    {
        int result;
        switch (operation)
        {
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
    
    public static int VidKalkulatora()
    {
        int num = getInt();
        try 
        {
            System.out.println("Выберете вид калькулятора: 1.Калькултор римских чисел 2.Калькулятор арабских чисел");
            //if (num != 1 && num != 2) 
            //{
            //    System.out.println("Введенное число должно равняться 1 или 2!!!");
            //    scanner.next();//рекурсия
            //    num = getInt();
            //} 
            if(num == 1) 
            {
                 RomanCalculate();
                 return num;
            } 
            else if(num == 2)
            {
                return calc(scanner.nextInt(),scanner.nextInt(),getOperation());
            }
            else
            {
                System.out.println("Введенное число должно равняться 1 или 2!!!");
                scanner.next();//рекурсия
                num = getInt();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }  
    public static String RomanCalculate() //Класс, работающий с римскими числами
    { 
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
        for (i = 0; i < 10; i++) 
            {
                if (letters[i].equals(Variable1)) //проверяем входит ли строка "Variable1" в массив строк массива "letters"
                {
                    Peremennaia1 = numbers[i];
                    flag1 = true;
                }
            }

            //Вводим второе число
        System.out.println("Введите второе число (от I до X): ");
        String Variable2 = num.nextLine();
        for (i = 0; i < 10; i++) 
        {
            if (letters[i].equals(Variable2)) 
            {
                Peremennaia2 = numbers[i];
                flag2 = true;
            }
        }

        if (flag1&&flag2) 
        {
            i = calc(Peremennaia1,Peremennaia2,getOperation());
            if(i<=10&&i>=0) {
                return letters[i - 1];
            }
        }
        else if (Peremennaia1<Peremennaia2)
        {
            System.out.println("Первое число больше второго!");
            EndOfProgram = RomanCalculate();
        }
        else
        { 
            System.out.println("Результат выходит за пределы");
            EndOfProgram = RomanCalculate();
        } 
        return EndOfProgram;
    }
}

