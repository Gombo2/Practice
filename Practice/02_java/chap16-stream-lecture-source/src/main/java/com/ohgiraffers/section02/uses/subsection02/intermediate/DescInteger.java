package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Comparator;

public class DescInteger implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
//        return -(o1 - o2);
        return o2 - o1;
    }
}
