import java.util.Scanner;

public class calculate {
    public static void main(String[] args) throws Exception, IllegalArgumentException, ArrayIndexOutOfBoundsException {
        System.out.println("Введите 2 переменные и знак");
        Scanner num1 = new Scanner(System.in);
        Main itog = new Main();
        String stroka = num1.nextLine();
        String answer = itog.calc(stroka);
        System.out.println("Результат " + answer);

    }
}

class Main{
    public static String calc(String input) throws Exception, IllegalArgumentException, ArrayIndexOutOfBoundsException {
        int result;
        String[] massiv = input.split(" ");
        if (massiv.length != 3) {
            throw new Exception();
        }
        int chislo1;
        int chislo2;
        boolean arabic = false;
        Scanner num2 = new Scanner(massiv[0]);
        boolean t1 = num2.hasNextInt();
        Scanner num3 = new Scanner(massiv[2]);
        boolean t2 = num3.hasNextInt();
        num2.close();
        num3.close();
        if (t1 && t2) {
            chislo1 = Integer.parseInt(massiv[0]);
            chislo2 = Integer.parseInt(massiv[2]);
        } else if (!t1 && !t2)
        {
            Roman conv1 = Roman.valueOf(massiv[0]);
            Roman conv2 = Roman.valueOf(massiv[2]);
            if ((conv1 instanceof Roman) && (conv2 instanceof Roman)) {
                chislo1 = conv1.getArabic();
                chislo2 = conv2.getArabic();
                arabic = true;
            } else throw new ArrayIndexOutOfBoundsException();
        } else throw new IllegalArgumentException();

        if (chislo1 <1 || chislo2 <1 || chislo1 >10 || chislo2 >10) {throw new Exception();}
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
            default -> throw new Exception();
        };

        String output;
        if (arabic) {
            if (result < 1) {
                throw new Exception();
            } else {
                output = String.valueOf(Roman.values()[result - 1]);
            }
        } else {output = Integer.toString(result);
        }

        return output;
    }
}
