import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception { // Может выбросить исключение типа Exception.
        System.out.print("Input:\n");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        // Читает следующую строку ввода пользователя и возвращает ее в качестве значения.
        // Затем это значение присваивается переменной input типа String.
        System.out.println("Output:\n" + calc(input));
        // Вызывает метод calc и передает в него значение переменной input в качестве аргумента.
        // Метод calc выполняет вычисления на основе введенного пользователем значения и возвращает результат.
    }

    private static String calc(String input) throws Exception {
        // // Код вычислений
        Konvert konvert = new Konvert();
        // Создание объекта Konvert позволяет использовать методы этого класса для выполнения операций с числами,
        // такими как проверка, является ли число римским, и преобразование римского числа в целое число.
        String[] operation = {"+", "-", "*", "/"};
        String[] regexOperation = {"\\+", "\\-", "\\*", "\\/"};

        int j = 0;
        for (int i = 0; i < operation.length; i++) {
            if (input.contains(operation[i])) {
                j = i;
                break;
            // Проверяется, содержит ли введенная пользователем строка input текущий оператор operation[i].
                // Если содержит, то значение переменной j устанавливается равным индексу оператора i
            }
        }
        String[] num = input.split(regexOperation[j]);
        // Разделяет введенную пользователем строку input на подстроки, используя регулярное выражение regexOperation[j]
        // в качестве разделителя. Результатом будет массив строк num, содержащий разделенные подстроки.
        if (num.length != 2) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (j > 2) { // Если операций будет больше 2, то Exception
            throw new Exception("т.к. строка не является математической операцией");
        }

        int a, b;
        if (konvert.isRoman(num[0]) == konvert.isRoman(num[1])) { // Проверяет, являются ли оба операнда
            // римскими числами или оба операнда не являются римскими числами.
            boolean isRoman = konvert.isRoman(num[0]);
            // Используется для проверки, является ли переданное число римским числом
            if (isRoman) {
                a = konvert.romanToInt(num[0]);
                b = konvert.romanToInt(num[1]);
                // Используется для преобразования римского числа, представленного в виде строки, в целочисленное значение
            }
            else {
                a = Integer.parseInt(num[0]);
                b = Integer.parseInt(num[1]);
                // Используется для преобразования строки в целочисленное значение.
                // Если операнды num[0] и num[1] не являются римскими числами,
                // то метод Integer.parseInt() будет использован для преобразования этих значений в целочисленные значения.
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

                if (isRoman) { // Преобразует целочисленное значение res в римское число в виде строки
                    if (res > 0) {
                        return String.valueOf((konvert.intToRoman(res)));
                        // Полученное римское число преобразуется в строку с помощью String.valueOf()
                        // и возвращается из метода calc().
                    }
                    else throw new Exception("т.к. в римской системе нет отрицательных чисел");
                    // Если результат res меньше или равен 0, то выбрасывается исключение
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
