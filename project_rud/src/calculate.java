import java.util.Scanner;

public class calculate {
    public static void main(String[] args) {
        System.out.println("Введите 2 переменные и знак");
        try {
        try {
            Scanner num1 = new Scanner(System.in);
            String stroka = num1.nextLine();
            String[] massiv = stroka.split(" ");
            Scanner num2 = new Scanner(massiv[0]);
            if (num2.hasNextInt()) {
                if (massiv.length == 3) {
                    Scanner num4 = new Scanner(massiv[1]);
                    char znak1 = num4.next().charAt(0);
                    if ((Integer.parseInt(massiv[0]) <= 10) && Integer.parseInt(massiv[2]) <= 10) {
                        switch (znak1) {
                            case '+':
                                int c = Integer.parseInt(massiv[0]) + Integer.parseInt(massiv[2]);
                                System.out.println("Результат " + c);
                                break;
                            case '-':
                                int d = Integer.parseInt(massiv[0]) - Integer.parseInt(massiv[2]);
                                System.out.println("Результат " + d);
                                break;
                            case '*':
                                int e = Integer.parseInt(massiv[0]) * Integer.parseInt(massiv[2]);
                                System.out.println("Результат " + e);
                                break;
                            case '/':
                                int f = Integer.parseInt(massiv[0]) / Integer.parseInt(massiv[2]);
                                System.out.println("Результат " + f);
                                break;
                            default:
                                System.out.println("Вы ввели некорректные значения");
                        }
                        ;
                    } else System.out.println("Введите числа меньше 10");
                } else System.out.println("Введите 2 числа и 1 знак!");
            } else {
                Scanner num5 = new Scanner(massiv[0]);
                String z = num5.next();
                num5 = new Scanner(massiv[2]);
                String w = num5.next();
                num5 = new Scanner(massiv[1]);
                char znak1 = num5.next().charAt(0);
                Roman arabic1 = Roman.valueOf(z);
                Roman arabic2 = Roman.valueOf(w);
                int arab1 = arabic1.getArabic();
                int arab2 = arabic2.getArabic();
                if ((arab1 <= 10) && (arab2 <= 10)) {
                    try {
                        switch (znak1) {
                            case '+':
                                int plus = arabic1.getArabic() + arabic2.getArabic();
                                Roman resultPlus = Roman.values()[plus - 1];
                                System.out.println("Результат " + resultPlus);
                                break;
                            case '-':
                                int minus = arabic1.getArabic() - arabic2.getArabic();
                                Roman resultminus = Roman.values()[minus - 1];
                                System.out.println("Результат " + resultminus);
                                break;
                            case '*':
                                int umnozh = arabic1.getArabic() * arabic2.getArabic();
                                Roman resultumnozh = Roman.values()[umnozh - 1];
                                System.out.println("Результат " + resultumnozh);
                                break;
                            case '/':
                                int razdel = arabic1.getArabic() / arabic2.getArabic();
                                Roman resultrazdel = Roman.values()[razdel - 1];
                                System.out.println("Результат " + resultrazdel);
                                break;
                            default:
                                System.out.println("Вы ввели некорректные значения");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Итоговое значение 0 или меньше. Таких переменных в римской нумерации я не знаю.");
                    }
                } else System.out.println("Введите числа меньше X");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Переменные могут быть либо арабскими, либо римскими");
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Введите 2 числа и 1 знак!");
    }
    }
}
