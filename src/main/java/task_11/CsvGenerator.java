package task_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This class generates .csv files and put it in main_data directory
 */
public class CsvGenerator {
    private static String file_name = Constants.DIR_STRING + "\\document.csv";

    /**
     * Read file line by line and adds info in array
     *
     * @param bufferedReader - reader form our .txt file
     * @return ArrayList with information - names and sites
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
     * generates data for .csv files randomly(pseudo)
     *
     * @param nameData - file with information - names and sites
     * @return randomly generated String
     */
    private String stringGeneration(ArrayList<String> nameData){
        int random_number = 100 + (int)(Math.random() * 901);
        int random_number2 = (int)(Math.random() * 21);
        int random_number3 = 21 + (int)(Math.random() * 21);
        int random_number4 = (int)(Math.random() * 1000000001);

        String sites = nameData.get(random_number3);
        String names = nameData.get(random_number2);
        return random_number + ";" + sites + ";" + random_number4 + ";" + names;
    }

    /**
     * Main method for .csv generation
     *
     * @param bufferedWriter - writer which writes info into output files
     * @param nameData - ArrayList filled with names and sites needed for previous method usage
     */
    private void dataGeneration(BufferedWriter bufferedWriter, ArrayList<String> nameData) {
        try {
            String mainLine = "id;url;time;user";
            bufferedWriter.write(mainLine + "\n");
            for (int i = 0; i < 10; i++) {
                String string = stringGeneration(nameData);
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CsvGenerator gen = new CsvGenerator();
        try {
            FileInputStream names = new FileInputStream(Constants.DIR_STRING + "\\namesAndSites.txt");
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
