package lesson2;

public class Homework2 {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "rdsjdjs1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println(arrayProcessing(array));
    }

    public static int arrayProcessing(String[][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0, parsed_number;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    parsed_number = Integer.parseInt(arr[i][j]);
                    sum += parsed_number;
                } catch (NumberFormatException e) { // Я так и не понял, почему если написать здесь catch MyArrayDataException, это не будет работать, выбрасываться все равно будет исключение NumberFormatException
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
        return sum;
    }
}
