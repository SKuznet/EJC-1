package task_11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ThreadCsvParser extends Thread{
    private File fileForParsing;
    private Map<String, Long> fileData;

    ThreadCsvParser(File fileForParsing, Map<String, Long> fileData) {
        this.fileForParsing = fileForParsing;
        this.fileData = fileData;
    }

    /**
     * Reads the file line by line, parse it then adds it to the map
     *
     * Key - username and url, value - time,
     * if map keys matches then values are summed up
     */
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileForParsing))) {
            String fileOneRow;
            reader.readLine();
            while((fileOneRow = reader.readLine()) != null) {
                String[] stringData = fileOneRow.split(Constants.DELIMITER);
                String url = stringData[1];
                String user = stringData[3];
                long time = Long.parseLong(stringData[2]);
                fileData.merge(user + Constants.DELIMITER + url, time, (oldTime, newTime) -> oldTime + newTime);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
