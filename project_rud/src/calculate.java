import java.util.Scanner;

public class calculate {
    public static void main(String[] args) {
        System.out.println("Введите 2 переменные и знак");
        Scanner num1 = new Scanner(System.in);
        Main itog = new Main();
        String stroka = num1.nextLine();
        String answer = itog.calc(stroka);
        System.out.println("Результат " + answer);

    }
}

class Main{
    public static String calc(String input){
        String mistake = "throws Exception";
        int result = 0;
        String[] massiv = input.split(" ");
        if (massiv.length !=3) {return mistake;}
        int chislo1;
        int chislo2;
        boolean arabic = false;
        try {
            chislo1 = Integer.parseInt(massiv [0]);
            chislo2 = Integer.parseInt(massiv [2]);
        } catch (NumberFormatException s) {
            try {
                Roman chislorome1 = Roman.valueOf(massiv[0]);
                Roman chislorome2 = Roman.valueOf(massiv[2]);
                chislo1 = chislorome1.getArabic();
                chislo2 = chislorome2.getArabic();
                arabic = true;
            } catch (IllegalArgumentException ss) {return mistake;}
        }
        if (chislo1 <1 || chislo2 <1 || chislo1 >10 || chislo2 >10) {return mistake;}
        String znak = massiv[1];
        switch (znak) {
            case "+" ->
                    result = chislo1+chislo2;
            case "-" ->
                    result = chislo1-chislo2;
            case "*" ->
                    result = chislo1*chislo2;
            case "/" ->
                    result = chislo1/chislo2;
            default -> {return mistake;}
        };

        String output;
        if (arabic) {
            if (result < 1) {
                return mistake;
            } else {
                output = String.valueOf(Roman.values()[result - 1]);
            }
        } else {output = Integer.toString(result);
        }

        return output;
    }
}
