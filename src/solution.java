import java.util.InputMismatchException;
import java.util.Scanner;

public class solution {


    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Введите выражение ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0].trim();
        String stable01 = blacks[1].trim();
        if (blacks.length >2) {
            System.out.println("Ошибка");
            return;
        }
        number1 = voll.romanToNumber(stable00);
        number2 = voll.romanToNumber(stable01);
        if (number1 < 0 && number2 < 0) {
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(stable01);
            if (operation == '/' && number2 ==0 ) {
                System.out.println("Ошибка, деление на ноль");
                return;
            }
            result = voll.calculated(number1, number2, operation);
            System.out.println("Результат арабских цифр:");
            System.out.print(result);
        } else {

            if (number1 == -1 || number2 == -1) {
                throw new RuntimeException("Используются одновременно разные системы исчисления");
            }
            result = voll.calculated(number1, number2, operation);
            System.out.println("Результат для римских цифр:");
            if (result < 0) {
               throw new RuntimeException("Римские числа не могут быть отрицательными");


            }
            String resultRoman = voll.convertNumToRoman(result);

            System.out.println(resultRoman);

        }
    }
}
