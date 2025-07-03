public class Array {
        public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
            if (array.length != 4) {
                throw new MyArraySizeException("Массив должен быть 4x4, у данного массива есть несоответствия: " + array.length + " строки.");
            }
            for (String[] row : array) {
                if (row.length != 4) {
                    throw new MyArraySizeException("Массив должен быть 4x4, у данного массива есть несоответствия: "+ row.length + " элементов.");
                }
            }

            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Преобразование не удалось. Неверные данные в: (" + i + "," + j + "): " + array[i][j]);
                    }
                }
            }
            System.out.println("Сумма массива: " + sum);
        }

    public static void main(String[] args) {
            String[][] arrayOne = {
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"}
            };

            String[][] arrayTwo = {
                    {"1"},
                    {"1", "2"},
                    {"1", "2", "3", "4"}
            };

            String[][] arrayThree = {
                    {"1", "2", "3", "4"},
                    {"!", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"}
            };

            String[][] arrayFour = {
                    {"1", "2", "3", "4", "5"},
                    {"1", "2", "3", "4", "5"},
                    {"1", "2", "3", "4", "5"},
                    {"1", "2", "3", "4", "5"}
            };

            try {
                Array.checkArray(arrayOne);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }

            try {
                Array.checkArray(arrayTwo);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }

            try {
                Array.checkArray(arrayThree);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
            try {
                Array.checkArray(arrayFour);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }

            int[] emptyArray = new int[0];
            System.out.println(emptyArray[0]);
        }
    }

