//2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

//Ответ: Если в матрице будут не целочисленные значени то будет исключение типа NumberFormatException.
//Это будет происходить каждый раз, когда найденное значение будет отлично от целочисленного или со значениями типа null.
//Также будет выводиться исключение ArrayIndexOutOfBoundsException если матрица будет пуста.


package ExceptionsSeminars.Seminar1;

public class Task2 {
    public static void main(String[] args) {
        String[][] arr = {{null}, {null}};
        sum2d(arr);
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
    return sum;
    }
}