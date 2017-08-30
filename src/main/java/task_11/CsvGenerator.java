package task_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvGenerator {
    private static String file_name = Constants.DIR_STRING + "\\doc.csv";

    /**
     * Reads file line by line and adds info in array
     *
     * @param bufferedReader - reader form our .txt file
     * @return ArrayList - list of information with names and sites
     */
    private ArrayList<String> inputData(BufferedReader bufferedReader){
        String strLine;
        ArrayList<String> words = new ArrayList<>();
        try {
            while ((strLine = bufferedReader.readLine()) != null){
                words.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    /**
     * Generates .csv files with random data
     *
     * @param nameData - file with information - names and sites
     * @return String - randomly generated String
     */
    private String stringGeneration(ArrayList<String> nameData){
        int randomNumber1 = 100 + (int)(Math.random() * 901);
        int randomNumber2 = (int)(Math.random() * 21);
        int randomNumber3 = 21 + (int)(Math.random() * 21);
        int randomNumber4 = (int)(Math.random() * 1000000001);

        String sites = nameData.get(randomNumber3);
        String names = nameData.get(randomNumber2);

        return randomNumber1 + Constants.DELIMITER + sites + Constants.DELIMITER + randomNumber4 + Constants.DELIMITER + names;
    }

    /**
     * Main method for .csv generation
     *
     * @param bufferedWriter - writer which writes info into output files
     * @param nameData - ArrayList filled with names and sites needed for previous method usage
     */
    private void dataGeneration(BufferedWriter bufferedWriter, ArrayList<String> nameData) {
        try {
            String mainLine = "id" + Constants.DELIMITER + "url" + Constants.DELIMITER + "time" + Constants.DELIMITER + "user";
            bufferedWriter.write(mainLine + "\n");
            for (int i = 0; i < 10; i++) {
                String string = stringGeneration(nameData);
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts generating of files
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        CsvGenerator gen = new CsvGenerator();
        try {
            FileInputStream names = new FileInputStream(Constants.DIR_STRING + "\\STRING_LIST.txt");
            DataInputStream in = new DataInputStream(names);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            FileWriter offStream = new FileWriter(file_name);
            BufferedWriter out = new BufferedWriter(offStream);
            ArrayList<String> data = new CsvGenerator().inputData(br);
            br.close();
            gen.dataGeneration(out, data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
