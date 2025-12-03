package ArrayRevision;

import java.util.ArrayList;
import java.util.List;

public class TestJustification {

    public static void singleString(List<String> curLine, int currentLength, int maxWidth,
            List<String> finalResult) {
        String result = curLine.get(0);
        int totalSpace = maxWidth - currentLength;
        while (totalSpace > 0) {
            result += " ";
            totalSpace--;
        }

        finalResult.add(result);

    }

    public static void multiString(List<String> curList, int currentLength, int maxWidth,
            List<String> finalResult) {
        int totalSpace = maxWidth - currentLength;
        int gap = curList.size() - 1;
        int evenSpace = totalSpace / gap;
        int addSpace = totalSpace % gap;

        for (int i = 0; i < curList.size() - 1; i++) {
            int space = 0;
            System.out.println("sss");
            String result = curList.get(i);
            while (space < evenSpace) {
                System.out.println("while");
                result += " ";
                space++;
            }
            curList.set(i, result);
        }
        int i = 0;
        while (i < addSpace) {
            String result = curList.get(i) + " ";
            curList.set(i, result);
            i++;
        }
        String result = "";
        for (int j = 0; j < curList.size(); j++) {
            System.out.println("jjjss");
            result += curList.get(j);
        }
        System.out.println("laukesh");
        finalResult.add(result);
    }

    public static void lastString(List<String> curList, int currentLength, int maxWidth, List<String> finalResult) {
        System.out.println("teissn");
        int totalSpace = maxWidth - currentLength;
        while (totalSpace > 0) {
            curList.add(" ");
            totalSpace--;

        }
        String strResult = "";
        for (int i = 0; i < curList.size(); i++) {
            strResult += curList.get(i);
        }
        finalResult.add(strResult);
        return;
    }

    public static void main(String[] args) {
        String words[] = { "What", "must", "be", "acknowledgment", "shall", "be" };
        int maxWidth = 16;
        List<String> curLine = new ArrayList<>();
        List<String> finalResult = new ArrayList<>();
        curLine.add(words[0]);
        int currentLength = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (currentLength + 1 + words[i].length() <= maxWidth) {
                curLine.add(" " + words[i]);
                currentLength = currentLength + 1 + words[i].length();
            } else {
                if (curLine.size() == 1) {
                    singleString(curLine, currentLength, maxWidth, finalResult);
                } else {
                    System.out.println(curLine);
                    multiString(curLine, currentLength, maxWidth, finalResult);
                }
                curLine = new ArrayList<>();
                curLine.add(words[i]);
                currentLength = words[i].length();
            }
        }
        // System.out.println(curLine);
        lastString(curLine, currentLength, maxWidth, finalResult);
        System.out.println(finalResult);

    }

}
