package Lesson2;

public class MainArray {

        public static void main(String[] args) {
            //Объявим двумерный строковый массив и заполним его элементами
            String[][] positiveArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}}; //позитивный тест
            String[][] negativeArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"~", "10", "11", "12"}, {"13", "14", "15", "16"}}; //негативный тест (в ячейке лежит символ или текст вместо числа)
            String[][] negativeArray0 = {{"1", "2", "3","4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}}; //негативный тест (задан массив другого размера)

            try {
                System.out.println("Sum = " + stringTest(positiveArray));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println("Sum = " + stringTest(negativeArray));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println("Sum = " + stringTest(negativeArray0));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }

        public static int stringTest(String[][] arr) throws MyArraySizeException, MyArrayDataException {
            int twoDimArray = 4;
            int sum = 0;

            if (arr.length != 4) {
                throw new MyArraySizeException(String.format("The array must be of size %dх%d", twoDimArray, twoDimArray));
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(String.format("In array[%d, %d] exception %s", i, j, arr[i][j]));
                    }
                }
            }

            return sum;
        }
    }

