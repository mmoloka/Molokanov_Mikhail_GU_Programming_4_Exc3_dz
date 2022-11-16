package controller;

import model.DataService;
import model.ExceptionService;
import model.FileService;

public class DataController {

    ExceptionService exceptionService = new ExceptionService();
    DataService dataService = new DataService();

    FileService fileService = new FileService();
    public int checkData(String data) {
        String[] dataArray = dataService.getArrayOfStrings(data);
        int count = 0;
        try {
            exceptionService.checkDataOnCountOfMembers(dataArray, 6);
            count++;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Вы ввели больше данных!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели меньше данных!");
        }
        try {
            exceptionService.checkDataOnSurnameFormat(dataArray);
            count++;
        } catch (IllegalArgumentException e) {
            System.out.println("Вы некорректно ввели фамилию!");
        }
        try {
            exceptionService.checkDataOnPatronymicsFormat(dataArray);
            count++;
        } catch (IllegalArgumentException e) {
            System.out.println("Вы некорректно ввели отчество!");
        }
        try {
            exceptionService.checkDataOnBirthDateFormat(dataArray);
            count++;
        } catch (NumberFormatException e) {
            System.out.println("Вы некорректно ввели дату рождения!");
        }
        try {
            exceptionService.checkDataOnTelephoneNumberFormat(dataArray);
            count++;
        } catch (NumberFormatException e) {
            System.out.println("Вы некорректно ввели номер телефона!");
        }
        try {
            exceptionService.checkDataOnGenderFormat(dataArray);
            count++;
        } catch (IllegalArgumentException e) {
            System.out.println("Вы некорректно ввели пол!");
        }
        try {
            exceptionService.checkDataOnNameFormat(dataArray);
            count++;
        } catch (IllegalArgumentException e) {
            System.out.println("Вы некорректно ввели имя!");
        }
        return count;
    }

    public void writeDataInFile(String data) {
        fileService.createFile(dataService.getArrayOfStrings(data));
    }
}
