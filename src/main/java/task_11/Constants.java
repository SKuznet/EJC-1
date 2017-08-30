package task_11;

import java.io.File;

public class Constants {

    static final String DIR_STRING = System.getProperty("user.dir") + "\\src\\main\\java\\task_11\\DATA";
    static final String OUTPUT_NAME = "output.csv";
    static final String HEADER = "user,url,time";
    static final String EXTENSION = ".csv";
    static final String DELIMITER = ",";
    static final File DIRECTORY = new File(System.getProperty("user.dir") + "\\src\\main\\java\\task_11\\DATA");
    static final int THREAD_AMOUNT = 10;
}
