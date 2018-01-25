package pl.morecraft.dev.jsp.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizator {

    public static List<String> changeToListOfTokens(String s) {
        List<String> newTokenList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreElements()) {
            newTokenList.add(st.nextToken());
        }

        return newTokenList;
    }


    protected static boolean compareTokens(List<String> tokenListToCompare, List<String> tokens) {
        List<String> temporaryTokenList = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals(tokenListToCompare.get(0))) {
                for (int j = i; j < i + tokenListToCompare.size(); j++) {
                    temporaryTokenList.add(tokens.get(j));
                }

                System.out.println(temporaryTokenList);
                System.out.println(tokenListToCompare);

                if (temporaryTokenList.equals(tokenListToCompare)) {
                    return true;
                }

                temporaryTokenList.clear();
            }
        }
        return false;
    }
}
