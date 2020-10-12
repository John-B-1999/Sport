package com.example.sportApp;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s = ")()())";
        longestValidParentheses(s);
    }
    public static int longestValidParentheses(String s) {
        Deque<Character> deque = new LinkedList<>();
        if(s.length() <= 1){
            return 0;
        }
        deque.addLast(s.charAt(0));
        int count = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if( !deque.isEmpty() && (deque.peekLast() == '(' && s.charAt(i) == ')')){
                deque.removeLast();
                count += 2;
                max = max > count ? max : count;
            }else{
                deque.addLast(s.charAt(i));
                count = 0;
            }
        }
        return max;
    }
}
