package pl.morecraft.dev.jsp.engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class IO {
    public static List<String> readFileToTokenList(String filename, List<String> tokens) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                while (stringTokenizer.hasMoreElements()) {
                    tokens.add(stringTokenizer.nextToken());
                }
            }

            br.close();
            return tokens;
        } catch (FileNotFoundException e) {
            System.err.printf("File [%s] not found\n", filename);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveReportToFile(List<String> reportList) {

    }
}
