package model;


public class DataService {

    public String[] getArrayOfStrings(String str) {
        return str.split(" ");
    }

    public String getSurname(String[] strArr) {
        for (String item : strArr) {
            if(item.toLowerCase().contains("ов")|| item.toLowerCase().contains("ова")) {
                return item;
            }
        }
        return null;
    }

    public String getPatronymics(String[] strArr) {
        for (String item : strArr) {
            if(item.toLowerCase().contains("вич") || item.toLowerCase().contains("вна")) {
                return item;
            }
        }
        return null;
    }

    public String getBirthDate(String[] strArr) {
        for (String item : strArr) {
            if(item.length() == 10) {
                if(item.charAt(2) == '.' && item.charAt(5) == '.' &&
                        Character.isDigit(item.charAt(0)) && Character.isDigit(item.charAt(1)) &&
                        Character.isDigit(item.charAt(3)) && Character.isDigit(item.charAt(4)) &&
                        Character.isDigit(item.charAt(6)) && Character.isDigit(item.charAt(7)) &&
                        Character.isDigit(item.charAt(8)) && Character.isDigit(item.charAt(9))) return item;
            }
        }
        return  null;
    }

    public String getTelephoneNumber(String[] strArr) {
        for (String item : strArr) {
            if(item.length() == 10) {
                int count = 0;
                for (int i = 0; i < item.length(); i++) {
                    if (Character.isDigit(item.charAt(i))) count++;
                        if (count == 10) return item;
                }
            }
        }
        return null;
    }

    public String getGender(String[] strArr) {
        for (String item : strArr) {
            if(item.equals("f") || item.equals("m")) return item;
        }
        return  null;
    }
     public String getName(String[] strArr) {
         for (String item : strArr) {
             if(!item.equals(getSurname(strArr)) && !item.equals(getPatronymics(strArr)) &&
                     !item.equals(getBirthDate(strArr)) && !item.equals(getTelephoneNumber(strArr)) &&
                     !item.equals(getGender(strArr))) {
                 int count = 0;
                 for (int i = 0; i < item.length(); i++) {
                     if (!Character.isDigit(item.charAt(i))) count++;
                        if(count == item.length()) return item;
                 }
             }
         }
         return null;
     }
}
