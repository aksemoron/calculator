import java.util.*;

import arithmetic.*;

public class Logic {


    public static void logic(String firstString, String arithmetic, String secondString) {
        int first = 0;
        int second = 0;
        int result =0;

        boolean flag = false;
        try {
            first = Integer.parseInt(firstString);
            second = Integer.parseInt(secondString);
        } catch (Exception e) {
            try {
                first = Converter.toArabic(firstString);
                second = Converter.toArabic(secondString);
                flag = true;
            } catch (Exception e1) {
                System.out.println("Вы ввели не верные данные");
            }
        }
        if (first<1 || first>10 || second<1|| second>10){
            System.out.println("Вы ввели не верные данные");
            System.exit(0);
        }
        Action action;
        if (arithmetic.equals("-")) {
            action = new Subtraction();
            result = action.invoke(first, second);
        }
        if (arithmetic.equals("*")){
            action = new Multiplication();
            result = action.invoke(first, second);
        }
        if (arithmetic.equals("/")){
            action = new Division();
            result = action.invoke(first, second);
        }
        if (arithmetic.equals("+")){
            action = new Addition();
            result = action.invoke(first, second);
        }
        if (flag){
            String roman = Converter.toRoman(result);
            System.out.println(roman);

        }
        else System.out.println(result);
    }
}
