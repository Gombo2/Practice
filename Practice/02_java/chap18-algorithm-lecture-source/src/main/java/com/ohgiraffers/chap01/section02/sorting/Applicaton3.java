package com.ohgiraffers.chap01.section02.sorting;

public class Applicaton3 {
    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 삽입 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *    - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     * 설명.
     *  예시 입력 1
     *    - 8
     *      33 39 20 4 16 24 19 28
     *  예시 출력 1
     *    - 4 16 19 20 24 28 33 39
     *
     * 설명.
     *  예시 입력 2
     *    - 6
     *      14 38 5 26 17 19
     *  예시 출력 2
     *    - 5 14 17 19 26 38
     * */
    public static void main(String[] args) {

    }

    public static void solution(int length, int[] arr) {
        for(int i = 0; i < length; i++) {
            int temp = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else break;
            }
        }
    }

}
