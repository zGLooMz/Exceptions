package ExceptionsSeminars.Seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) throws Exception {
        String userDate = getUserDate("Введите через пробел данные в формате:\n Фамилия Имя Отчество Дата_рождения(dd.mm.yyyy) Номер_телефона Пол(символ латиницей f или m)");
        if (checkAmount(userDate)) {
            System.out.println(stringValidate(userDate));
        } else {
            System.out.println("Проверьте ввод!");
        }

    }

    private static Boolean checkAmount(String userDate) {
        String[] words = userDate.split(" ");
        if (words.length < 6) {
            System.out.println("Введено мало данных!");
            return false;
        }
        if (words.length > 6) {
            System.out.println("Введено слишком много данных!");
            return false;
        }
        return true;
    }

    public static String stringValidate(String userDate) throws Exception{
        char[] chars = userDate.toCharArray();
        StringBuilder surName = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder secondName = new StringBuilder();
        StringBuilder birthDate = new StringBuilder();
        StringBuilder phone = new StringBuilder();
        StringBuilder sex = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == ' ') {
                flag ++;
                continue;
            }
            switch (flag) {
                case 0:
                    if (Character.isLetter(cur)){
                        surName.append(cur);
                    }else {
                        return "Фамилия должна состоять только из букв!";
                    }
                    break;
                case 1:
                    if (Character.isLetter(cur)){
                        name.append(cur);
                    }else {
                        return "Имя должно состоять только из букв!";
                    }
                    break;
                case 2:
                    if (Character.isLetter(cur)){
                        secondName.append(cur);
                    }else {
                        return "Отчество должно состоять только из букв!";
                    }
                    break;
                case 3:
                    if (Character.isDigit(cur) || cur == 46){
                        birthDate.append(cur);
                    }else {
                        return "Формат даты рождения : dd.mm.yyyy!";
                    }
                    break;
                case 4:
                    if (Character.isDigit(cur)){
                        phone.append(cur);
                    }else {
                        return "Номер телефона должен состоять только из цифр!";
                    }
                    break;
                case 5:
                    if (cur == 109 || cur == 102){
                        sex.append(cur);
                    }else {
                        return "Для указания пола введите либо 'm' либо 'f'!";
                    }
                    break;
            }
        }
        
        // check birthDate
        String dateString = String.format("%s", birthDate);
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);
        } catch (Exception e){
            return "Введена некоректная дата рождения! \n" + e;
        }
        
        if (surName.length() < 2){
            return "Фамилия не может состоять из одного символа!";
        }
        if (name.length()<2){
            return "Имя не может состоять из одного символа!";
        }
        if (secondName.length() < 2){
            return "Отчество не может состоять из одного символа!";
        }
        if (birthDate.length() != 10){
            return "Длина введенной даты не соответствует шаблону dd.mm.yyyy!";
        }
        if (phone.length() != 7){
            return "Длина номера телефона должна быть 7 цифр!";
        }
        if (sex.length() != 1){
            return "Проверьте ввод обозначающий Ваш пол!";
        }
        String sendData = String.format("<%s><%s><%s><%s><%s><%s>", surName, name, secondName, birthDate, phone, sex);
        String fileName = String.format("%s", surName);
        saveData(sendData, fileName);
        return  sendData;
    }

    public static String getUserDate(String title) {
        Scanner line = new Scanner(System.in, "CP866");
        System.out.println(title);
        String str = line.nextLine();
        line.close();
        return str;
    }

    public static void saveData(String string, String surName) throws Exception {
        try (FileWriter fw = new FileWriter(surName, true)) {
            fw.write(string+"\n");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}