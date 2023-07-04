//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 

package ExceptionsSeminars.Seminar2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "ibm866");
        System.out.print("Введите строку: ");
        String myStr = scanner.nextLine();
        scanner.close();
        if (myStr.isEmpty()) {
            throw new NullPointerException("Пустые строки вводить нельзя");
        }
        System.out.println("Введенная строка: " + myStr);
    }
}
