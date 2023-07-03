package com.example.testcode;

public class RemoveLetter {
    public static void remove(String str) {
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

        for (int i = 0; i < orderArray.length; i++) {
            String result = "";
            char orderEle = (char) orderArray[i];
            if (orderEle > 0) {
                for (int j = 0; j < charArray.length; j++) {
                    char c = charArray[j];
                    if (orderEle == c) {
                        charArray[j] = 0;
                    }
                }
                for (char c : charArray) {
                    if ((int) c != 0) {
                        result = result + c;
                    }
                }
                System.out.println("->" + result);
                remove(result);
            }
        }
    }
}
