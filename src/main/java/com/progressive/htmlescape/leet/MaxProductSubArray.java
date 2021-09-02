package com.progressive.htmlescape.leet;

//problem:->https://leetcode.com/problems/maximum-product-subarray/
// incomplete
public class MaxProductSubArray {
    public static void main(String[] args) {

        int[] input = {2, 3, -2, 4};
        int ans = input[0];
        int max = ans, min = ans;

        for (int i = 1; i < input.length; i++) {
            System.out.println("1.curmax=" + max);
            System.out.println("1.curmin=" + min);
            if (input[i] < 0) {
                System.out.println("swapping");
                max = max + min;
                min = max - min;
                max = max - min;
            }


            max = ((max * input[i] > max) ? max * input[i] : max);
            min = ((min * input[i] < min) ? min * input[i] : min);
            ans = ans > max ? ans : max;
        }
        System.out.println(ans);
    }
}
