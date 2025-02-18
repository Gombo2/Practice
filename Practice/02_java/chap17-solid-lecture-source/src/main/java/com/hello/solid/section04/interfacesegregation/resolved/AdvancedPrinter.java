package com.hello.solid.section04.interfacesegregation.resolved;

public class AdvancedPrinter implements MultiFunctionPrinter {

    @Override
    public void print() {
        System.out.println("고급 프린터로 문서를 힘차게 인쇄합니다.");
    }

    @Override
    public void scan() {
        System.out.println("문서를 깔끔하게 스캔합니다.");
    }

    @Override
    public void fax() {
        System.out.println("심지어 fax도 보냅니다.");
    }
}
