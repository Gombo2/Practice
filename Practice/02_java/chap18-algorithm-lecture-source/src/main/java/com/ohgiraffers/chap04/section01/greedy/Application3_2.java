package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Application3_2 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());                // 회의 수
        ArrayList<Time> timeList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());      // 시작 시간
            int end = Integer.parseInt(st.nextToken());        // 종료 시간

            timeList.add(new Time(start, end));
        }

        Collections.sort(timeList);

        int endTime = 0;
        int sameTime = 0;
        for(Time dis: timeList) {
            if(dis.start >= endTime && dis.start >= sameTime) {
                if(dis.start == dis.end) {
                    max_count++;
                    sameTime = dis.start;
                    continue;
                }
                endTime = dis.end;
                max_count++;
            }
        }

        return max_count;
    }
}
class Time implements Comparable<Time> {
    public int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) return o.start - this.start;      // 시작시간 내림차순
        else return this.end - o.end;                           // 종료시간 오름차순
    }
}