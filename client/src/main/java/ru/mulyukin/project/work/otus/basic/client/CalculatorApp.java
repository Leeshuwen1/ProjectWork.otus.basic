package ru.mulyukin.project.work.otus.basic.client;

public class CalculatorApp {
    private char sing;

    public CalculatorApp() {
        this.sing = sing;
    }


    public static int calculator(char sing, int a, int b){
        int result = 0;
        if(sing == '+'){
            result = a + b;
            System.out.println(a + " + " + b + " = " + result);
        } else if (sing == '-') {
            result = a - b;
            System.out.println(a + " - " + b + " = " + result);
        } else if (sing == '*') {
            result = a * b;
            System.out.println(a + " * " + b + " = " + result);
        } else if (sing == '/') {
            result = a / b;
            System.out.println(a + " / " + b + " = " + result);
        }else {
            System.out.println("Вы ввели не верную операцию");
        }
        return result;
    }
}
