package GraphStriver;

import java.util.ArrayList;

public class wordLadderSecond {

    public static void findWord(ArrayList<ArrayList<String>> finalResult, String curString, String targetString,
            ArrayList<String> tempResult, ArrayList<String> wordList) {
        if (curString.equals(targetString)) {
            ArrayList<String> temp = new ArrayList<>(tempResult);
            temp.add(targetString);
            finalResult.add(temp);
            return;
        }
        tempResult.add(curString);
        for (int i = 0; i < curString.length(); i++) {
            char tempChar[] = curString.toCharArray();
            char curChar = tempChar[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                tempChar[i] = ch;
                String nextString = new String(tempChar);
                if (wordList.contains(nextString) && !tempResult.contains(nextString)) {
                    findWord(finalResult, nextString, targetString, tempResult, wordList);
                }
            }
            tempChar[i] = curChar;
        }
        tempResult.remove(tempResult.size() - 1);

    }

    public static void main(String[] args) {

        String startWord = "der", targetWord = "dfs";
        String wordList[] = { "des", "der", "dfr", "dgt", "dfs" };
        ArrayList<String> word = new ArrayList<>();
        for (int i = 0; i < wordList.length; i++) {
            word.add(wordList[i]);

        }
        ArrayList<ArrayList<String>> finalResult = new ArrayList<>();
        findWord(finalResult, startWord, targetWord, new ArrayList<>(), word);
        int countMinLenth = Integer.MAX_VALUE;
        for (int i = 0; i < finalResult.size(); i++) {
            countMinLenth = Math.min(countMinLenth, finalResult.get(i).size());
        }
        ArrayList<ArrayList<String>> temResult = new ArrayList<>();
        for (int i = 0; i < finalResult.size(); i++) {
            if (finalResult.get(i).size() == countMinLenth) {
                temResult.add(new ArrayList<>(finalResult.get(i)));
            }

        }
        System.out.println(temResult);
    }

}
