package com.ohgiraffers.section01.array;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. 배열을 사용해 간단한 카드 뽑기 게임을 작성해 보자. */
        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] numbers = {"1", "2", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING", "ACE"};

        int randomShapeIndex = (int) (Math.random() * shape.length);
        int randomNumberIndex = (int) (Math.random() * numbers.length);

        System.out.println("당신이 뽑은 카드는 " + shape[randomShapeIndex] + " "
                + numbers[randomNumberIndex] + "카드 입니다.");


    }
}
