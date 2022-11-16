package model;

public class ExceptionService {

    DataService dataService = new DataService();
    public void checkDataOnCountOfMembers(String[] strArr, int count) {
        if(strArr.length > count) throw new StringIndexOutOfBoundsException();
        if(strArr.length < count) throw new IndexOutOfBoundsException();
    }

    public void checkDataOnSurnameFormat(String[] strArr) {
        if(dataService.getSurname(strArr) == null) throw new IllegalArgumentException();
    }

    public void checkDataOnPatronymicsFormat (String[] strArray) {
        if(dataService.getPatronymics(strArray) == null) throw new IllegalArgumentException();
    }

    public void checkDataOnGenderFormat (String[] strArray) {
        if(dataService.getGender(strArray) == null) throw new IllegalArgumentException();
    }

    public void checkDataOnBirthDateFormat(String[] strArr) {
        if(dataService.getBirthDate(strArr) == null) throw  new NumberFormatException();
    }

    public void checkDataOnTelephoneNumberFormat(String[] strArr) {
        if(dataService.getTelephoneNumber(strArr) == null) throw  new NumberFormatException();
    }

    public void checkDataOnNameFormat(String[] strArr) {
        if(dataService.getName(strArr) == null) throw new IllegalArgumentException();
    }

}
