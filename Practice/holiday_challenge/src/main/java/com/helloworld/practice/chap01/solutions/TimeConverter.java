package com.helloworld.practice.chap01.solutions;

public class TimeConverter {

    /**
     * 문제 3: 초 단위 시간을 시, 분, 초로 변환하기
     * 
     * 초 단위의 시간이 주어졌을 때, 이를 "시:분:초" 형식으로 변환하는 프로그램을 작성하시오.
     * 예; 3665초 = 1시간 1분 5초
     *
     * 예상 출력:
     * [시간 변환 결과]
     * 3665초는 1시간 1분 5초입니다.
     * 7200초는 2시간 0분 0초입니다.
     * 45초는 0시간 0분 45초입니다.
     *
     * @param seconds 변환할 조 단위 시간
     * @return "시:분:초" 형식의 문자열
     */
    public String convertSeconds(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        return hours + "시간 " + minutes + "분 " + remainingSeconds + "초입니다.";
    }

    public static void main(String[] args) {
        TimeConverter converter = new TimeConverter();
        
        /* 테스트 케이스 */
        int[] testCases = {3665, 7200, 45};

        System.out.println("[시간 변환 결과]");
        for (int seconds : testCases) {
            String result = converter.convertSeconds(seconds);
            System.out.println(seconds + "초는 " + result + "입니다.");
        }
        
    }
}
