package com.hello.solid.section04.interfacesegregation.resolved;

public class BasicPrinter implements PrinterOnly {
    @Override
    public void print() {
        System.out.println("기본 프린터가 문서를 인쇄합니다.");
    }
}
