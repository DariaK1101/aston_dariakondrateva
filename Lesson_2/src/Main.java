public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkNumbers(4, 5));
        addNumber(-9);
        System.out.println(addNumber1(-11));
        printString("строка", 3);
        System.out.println(isLeapYear(2024));
        int[] newArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        makeArray(newArray);
        int[] massive = new int[100];
        massiveForTaskEleven(massive);
        int[] massive2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        massiveForTaskTwelve(massive2, 6);
        int[][] massive3 = new int[3][3];
        massiveDiagonal(massive3);
        whatInitialValue(5, 15);
    }


    // Задание 1. Создайте метод printThreeWords(),
    // который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
    public static void printThreeWords() {
        System.out.println("Задание 1:");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание 2. Создайте метод checkSumSign(),
    // в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите.
    // Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
    // то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”.
    public static void checkSumSign() { //задание 2
        System.out.println("Задание 2:");
        int a = 7;
        int b = 9;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание 3. Создайте метод printColor() в теле которого задайте int переменную value
    // и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
    // то в консоль метод должен вывести сообщение “Красный”,
    // если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    // если больше 100 (100 исключительно) - “Зеленый”.
    public static void printColor() {
        System.out.println("Задание 3:");
        int value = 125;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value < 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }

    }

    // Задание 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
    // то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”.
    public static void compareNumbers() {
        System.out.println("Задание 4:");
        int a = 11;
        int b = 15;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    // Задание 5. Напишите метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    public static boolean checkNumbers(int a, int b) {
        System.out.println("Задание 5:");
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    // Задание 6. Напишите метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void addNumber(int c) {
        System.out.println("Задание 6:");
        if (c >= 0) {
            System.out.println("Число " + c + " - положительное");
        } else {
            System.out.println("Число " + c + " - отрицательное");
        }
    }

    // Задание 7. Напишите метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    //Замечание: ноль считаем положительным числом.
    public static boolean addNumber1(int d) {
        System.out.println("Задание 7:");
        return (d <= 0);
    }

    // Задание 8. Напишите метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз.
    public static void printString(String str, int count) {
        System.out.println("Задание 8:");
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // Задание 9. Напишите метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean isLeapYear(int year) {
        System.out.println("Задание 9:");
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    // Задание 10. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0.
    public static void makeArray(int[] args) {
        System.out.println("Задание 10:");
        for (int i = 0; i < args.length; i++) {
            if (args[i] == 0) {
                args[i] = 1;
            } else {
                args[i] = 0;
            }
            System.out.print((args[i]) + " ");
        }
    }

    // Задание 11.Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    public static void massiveForTaskEleven(int[] arr) {
        System.out.println("\nЗадание: 11");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nДлина массива:" + arr.length);
    }

    // Задание 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2.
    public static void massiveForTaskTwelve(int[] arr, int count) {
        System.out.println("\nЗадание: 12");
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < count) {
                System.out.print((arr[i] *= 2) + " ");
            } else {
                System.out.print((arr[i]) + " ");
            }
    }

    // Задание 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    public static void massiveDiagonal(int[][] arr) {
        System.out.println("\nЗадание 13:");
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 3;
            arr[i][arr.length - i - 1] = 3;
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Задание 14. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
    public static int[] whatInitialValue(int len, int initialValue) {
        System.out.println("\nЗадание 14:");
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.print(newArr[i] = initialValue);
        }
        return newArr;
    }
}