package task_11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Multithreaded csv parser with output report
 *
 * Parses info about users url activity
 */
public class MultiThreading {
    private volatile Map<String, Long> reportData = new ConcurrentHashMap<>();

    private ArrayList<File> getAllCsvFiles() {
        ArrayList<File> result = new ArrayList<>();
        File[] filesInFolder = Constants.DIRECTORY.listFiles();
        if (filesInFolder != null) {
            for (File file : filesInFolder) {
                if (file.toString().endsWith(Constants.EXTENSION)) {
                    result.add(file);
                }
            }
        }
        result.removeIf(o -> o.toString().endsWith(Constants.OUTPUT_NAME));
        return result;
    }

    /**
     * parses info by multithreading into reportData
     */
    private void processAllFilesByMultiThreading() {
        ArrayList<File> csvFiles = getAllCsvFiles();
        int threadCount = Constants.THREAD_AMOUNT;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (File csvFile: csvFiles) {
            executorService.execute(new ThreadCsvParser(csvFile, reportData));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * output report about users's activities
     */
    private void writeToFile() {
        File outputFile = new File(Constants.DIRECTORY,Constants.OUTPUT_NAME);
        try (FileWriter output = new FileWriter(outputFile)) {
            output.write(Constants.HEADER + "\n");
            Map<String, Long> treeMap = new TreeMap<>(reportData);
            for (Map.Entry keyAndValue : treeMap.entrySet()){
                output.write(keyAndValue.getKey() + Constants.DIVIDER + keyAndValue.getValue());
                output.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void go() {
        processAllFilesByMultiThreading();
        writeToFile();
    }
}
