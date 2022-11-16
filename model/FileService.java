package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    DataService dataService = new DataService();

    public void writeInFile(FileWriter fw, String[] strArr ) {
        try {
            fw.write("<" + dataService.getSurname(strArr) + ">" +
                    "<" + dataService.getName(strArr) + ">" +
                    "<" + dataService.getPatronymics(strArr) + ">" +
                    "<" + dataService.getBirthDate(strArr) + ">" +
                    "<" + dataService.getTelephoneNumber(strArr) + ">" +
                    "<" + dataService.getGender(strArr) + ">");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void createFile(String[] strArr) {
        try {
            File file = new File(dataService.getSurname(strArr) + ".txt");
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, true);
                fw.append('\n');
                writeInFile(fw, strArr);
            }
            else {
                FileWriter fw = new FileWriter(file, true);
                writeInFile(fw, strArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
