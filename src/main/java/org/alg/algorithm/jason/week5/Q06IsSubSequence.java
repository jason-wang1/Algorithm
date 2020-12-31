package org.alg.algorithm.jason.week5;

public class Q06IsSubSequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Q06IsSubSequence().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)){
                j ++;

                if (j == s.length())
                    return true;
            }
        }

        return false;
    }
}
