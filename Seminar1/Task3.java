// 3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя. 

package ExceptionsSeminars.Seminar1;

import java.util.Arrays;

public class Task3 {
    public static void main (String[] args) {
        int[] myArray1 = new int []{3, 8, 4}; 
        int[] myArray2 = new int []{4, 9, 1};
        int[] result = new int[3];

        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1.length != myArray2.length){
                throw new RuntimeException("Длины массивов не равны");
                } 
                    
            else if (myArray1 == null || myArray2 == null) {
                throw new RuntimeException("Массив не может быть пустым");
            }
                    
            else {
                result[i] = myArray1[i] - myArray2[i];
            }
        }
        System.out.println("Конечный массив: " + Arrays.toString(result));
    }
}
