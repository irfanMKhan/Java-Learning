package com.topic.test;

import java.util.Arrays;

public class fpp {

    public int is121(int[] a) {
        int len = a.length;
        if (len < 3) {
            return 0;
        }

        if (a[0] != 1 || a[len - 1] != 1) {
            return 0;
        }

        int c = 0, s = 0, e = 0;

        for (int i = 0; i < len; i++) {

            if (a[i] != 1 && a[i] != 2) return 0;
            if (a[i] == 1) {
                c++;
                continue;
            }
            if (a[i] == 2) {
                s = i;
                break;
            }
        }

        for (int i = len - 1; i > -1; i--) {
            if (a[i] != 1 && a[i] != 2) return 0;
            if (a[i] == 1) c--;
            if (c == -1) return 0;
            if (a[i] == 2) {
                e = i;
                break;
            }
        }

        for (int i = s; i <= e; i++) {
            if (a[i] != 1 && a[i] != 2) return 0;
        }

        return 1;
    }

    public int is123(int[] a) {
        int len = a.length;
        int s = 1;
        for (int i = 0; i < len; i++) {
            if (a[i] == s) {
                if (s == 3) s = 1;
                else s++;
            } else return 0;
        }
        if (s == 1) return 1;
        else return 0;
    }

    public char[] f(char[] chars, int start, int len) {
        if (chars.length == 0 || len < 0 || start < 0 || start + len > chars.length) {
            return null;
        }
        if (len == 0) return new char[]{};

        char[] newArr = new char[len];
        for (int i = start; i < start + len; i++) {
            newArr[i-start] = chars[i];
        }
        return newArr;
    }

    public int isConcatenatedSum(int n, int catlen) {
        int num = n, sum = 0;

        while(n > 0) {
            int digit = n % 10;
            n /= 10;
            int concat = 0;
            for (int i=0; i<catlen; i++) {
                concat = concat * 10 + digit;
            }
            sum += concat;
        }

        return sum == num ? 1 : 0;
    }

    public int[] encodeNumber(int num) {
        int a;
        int b = 0;
        a = (b=0);
        if(num <= 1) return null;
        int n = num;
        int len = 0;
        for (int i=2; i<=n; i++) {
            while (n%i==0) {
                n /= i;
                len++;
            }
        }



        int[] factors = new int[len];
        int idx = 0;
        n = num;
        for (int i=2; i<=n; i++) {
            while (n%i==0) {
                n /= i;
                factors[idx++] = i;
            }
        }
        return factors;
    }

}
