package org.example;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Logging {

    public static void writeToLogFile(String msg, String nameLogFile){
        try (FileWriter fw = new FileWriter(nameLogFile, true)) {
            fw.write(msg);
            fw.write(LocalDateTime.now().toString());
            fw.write("\n");
        }
        catch (Exception e){
            System.out.println("Ошибка записи информации");
        }
    }


}
