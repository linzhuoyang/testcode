package com.example.testcode;

public class InsteadLetter {

    public static void instead(String str) {
        char[] charArray = str.toCharArray();
        int[] tempArray = new int[26];
        int[] orderArray = new int[26];
        int order = 0;
        int begin = "a".charAt(0);
        for (int i = 1; i < charArray.length; i++) {
            char front = charArray[i - 1];
            char after = charArray[i];
            if (front == after) {
                tempArray[((int) front) - begin]++;
                if (tempArray[((int) front) - begin] == 2) {
                    orderArray[order] = front;
                    order++;
                }
            }
        }
        String result = "";
        String letter = "";
        char replaceLetter = 0;
        for (int i = 0; i < orderArray.length; i++) {
            char orderEle = (char) orderArray[i];
            if (orderEle > 0) {
                for (int j = 1; j < charArray.length; j++) {
                    char front = charArray[j - 1];
                    char after = charArray[j];
                    if (orderEle == front) {
                        letter = letter + orderEle;
                        if (front != after && orderEle != begin) {
                            replaceLetter = (char) ((int) charArray[j - 1] - 1);
                            charArray[j - 1] = replaceLetter;
                        } else {
                            charArray[j - 1] = 0;
                        }
                    }
                }
                for (char c : charArray) {
                    if ((int) c != 0) {
                        result = result + c;
                    }
                }
                System.out.println("->" + result + ","+ letter+" is replaced by "+ replaceLetter);
                instead(result);
            }
        }
    }
}
