// 4. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя. 
// Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше

package ExceptionsSeminars.Seminar1;

import java.util.Arrays;

public class Task4 {
    public static void main (String[] args) {
        int[] myArray1 = new int []{7, 15, 9}; 
        int[] myArray2 = new int []{1, 5, 9};
        int[] result = new int[3];

        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1.length != myArray2.length){
                throw new RuntimeException("Длины массивов не равны");
                } 
                    
            else if (myArray1 == null || myArray2 == null) {
                throw new RuntimeException("Массив не может быть пустым");
            }

            else if (myArray2[i] ==0){
                throw new RuntimeException("Деление на ноль невозможно");
            }
                    
            else {
                result[i] = myArray1[i]/myArray2[i];
            }
        }
        System.out.println("Конечный массив: " + Arrays.toString(result));
    }
}