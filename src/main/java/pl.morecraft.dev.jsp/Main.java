package pl.morecraft.dev.jsp;

import pl.morecraft.dev.jsp.engine.IO;
import pl.morecraft.dev.jsp.engine.ReportCreator;
import pl.morecraft.dev.jsp.engine.Search;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder path = new StringBuilder("src/main/java/test/");
        String filenameEnding = "_projekt_X";
        String index = "12478"; //numer indeksu studenta
        String fileExtension = ".java";
        String psvmMethod = "public static void main(String[] args)";
        String methodName = "public static int[][][] mySort(int[] dane)";
        List<String> tokens = new ArrayList<>();
        StringBuilder fileName = new StringBuilder();
        StringBuilder className = new StringBuilder();
        StringBuilder checkpoint = new StringBuilder();

        fileName.append("s").append(index).append(filenameEnding).append(fileExtension);
        className.append("s").append(index).append(filenameEnding);

        IO.readFileToTokenList(String.valueOf(path.append(fileName)), tokens);
        checkpoint.append(Search.lookForClass(tokens, String.valueOf(className)));
        checkpoint.append(Search.lookForPSVM(tokens, psvmMethod));
        checkpoint.append(Search.lookforMethod(tokens, methodName));
        checkpoint.append(Search.checkForBrackets(tokens));

        ReportCreator.finalCheck(checkpoint, index);

        System.out.println(checkpoint);
    }
}
