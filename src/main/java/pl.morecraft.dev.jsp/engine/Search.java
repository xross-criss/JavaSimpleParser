package pl.morecraft.dev.jsp.engine;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public static char lookForClass(List<String> tokens, String s) {
        List<String> tokenListToCompare;
        tokenListToCompare = Tokenizator.changeToListOfTokens(s);

        if (Tokenizator.compareTokens(tokenListToCompare, tokens)) {
            return '1';
        } else {
            return '0';
        }


/* Tokeny są zczytwane w postaci poniżej (nowa linia to nowy token)
            package
            test;
            public
            class
            s12478_projekt_X
            {
            public
            static
            void
            main(String[]
            args)
            {
            }
            public
            static
            int[][][]
            mySort(int[]
            dane){
            return
            null;
            }
            }*/
    }


    public static char lookForPSVM(List<String> tokens, String psvmMethod) {
        List<String> tokenListToCompare;
        tokenListToCompare = Tokenizator.changeToListOfTokens(psvmMethod);

        if (Tokenizator.compareTokens(tokenListToCompare, tokens)) {
            return '1';
        } else {
            return '0';
        }
    }

    public static char lookforMethod(List<String> tokens, String methodName) {
        List<String> tokenListToCompare;
        tokenListToCompare = Tokenizator.changeToListOfTokens(methodName);

        if (Tokenizator.compareTokens(tokenListToCompare, tokens)) {
            return '1';
        } else {
            return '0';
        }
    }

    public static char checkForBrackets(List<String> tokens) {
        List<Character> list = new ArrayList<>();
        int parantheses = 0, brackets = 0, brace = 0;

        for (String token : tokens) {
            char[] tab = token.toCharArray();

            for (char c : tab) {
                list.add(c);
            }
        }

        for (Character ch : list) {
            if (ch.equals('(')) {
                parantheses += 1;
            } else if (ch.equals('[')) {
                brackets += 1;
            } else if (ch.equals('{')) {
                brace += 1;
            } else if (ch.equals(')')) {
                parantheses -= 1;
            } else if (ch.equals(']')) {
                brackets -= 1;
            } else if (ch.equals('}')) {
                brace -= 1;
            }
        }

        if (parantheses == 0 && brackets == 0 && brace == 0) {
            return '1';
        } else {
            return '0';
        }

    }
}
