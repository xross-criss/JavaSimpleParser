package pl.morecraft.dev.jsp.engine;

import java.util.ArrayList;
import java.util.List;

public class ReportCreator {
    public static void finalCheck(StringBuilder checkpoint, String index) {
        List<String> reportList = new ArrayList<>();
        String sb = index + " - ";
        char[] list = checkpoint.toString().toCharArray();
        boolean validator = true;

        if (list[0] == '0' || list[1] == '0') {
            reportList.add(sb + "problem z wymaganą klasą");
        } else if (list[2] == '0') {
            reportList.add(sb + "problem z wymaganą metodą");
        } else if (list[3] == '0') {
            reportList.add(sb + "problem z klasą");
        } else {
            reportList.add(sb + "ok");
        }

        IO.saveReportToFile(reportList);
    }
}
