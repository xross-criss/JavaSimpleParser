package pl.morecraft.dev.jsp.engine;

import java.io.*;
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

    public static void saveReportToFile(List<String> reportList, String filename) {
        try {

            File file = new File(filename);

            if (!file.exists()) {
                if (file.createNewFile()) {
                    throw new IOException("File could not be created");
                }
            } else {
                System.out.println("File [" + filename + "] overwritten!");
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (String s : reportList) {
                bw.write(s.toString());
            }
            //bw.write(reportList.toString());

            bw.close();
        } catch (IOException e) {

        }
    }
}
