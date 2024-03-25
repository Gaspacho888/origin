import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception { 
        System.out.print("Input:\n");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        System.out.println("Output:\n" + calc(input));
    }

    private static String calc(String input) throws Exception {
        
        Konvert konvert = new Konvert();
        String[] operation = {"+", "-", "*", "/"};
        String[] regexOperation = {"\\+", "\\-", "\\*", "\\/"};

        int j = 0;
        for (int i = 0; i < operation.length; i++) {
            if (input.contains(operation[i])) {
                j = i;
                break;
            }
        }
        String[] num = input.split(regexOperation[j]);
        if (num.length != 2) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (j > 2) { 
            throw new Exception("т.к. строка не является математической операцией");
        }

        int a, b;
        if (konvert.isRoman(num[0]) == konvert.isRoman(num[1])) { 
            boolean isRoman = konvert.isRoman(num[0]);
            if (isRoman) {
                a = konvert.romanToInt(num[0]);
                b = konvert.romanToInt(num[1]);
            }
            else {
                a = Integer.parseInt(num[0]);
                b = Integer.parseInt(num[1]);
            }

            int res;
            if ((a > 0 && b > 0) && (a <= 10 && b <= 10)) {
                switch (operation[j]) {
                    case "+":
                        res = (a + b);
                        break;
                    case "-":
                        res = (a - b);
                        break;
                    case "*":
                        res = (a * b);
                        break;
                    default:
                        res = (a / b);
                        break;
                }

                if (isRoman) { 
                    if (res > 0) {
                        return String.valueOf((konvert.intToRoman(res)));
                    }
                    else throw new Exception("т.к. в римской системе нет отрицательных чисел");
                }
                else {
                    return String.valueOf(res);
                }
            }
            else throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        }
        else throw new Exception("т.к. используются одновременно разные системы счисления");
    }
}
