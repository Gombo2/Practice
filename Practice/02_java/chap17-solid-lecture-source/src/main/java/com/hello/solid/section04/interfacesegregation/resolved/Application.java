package com.hello.solid.section04.interfacesegregation.resolved;

public class Application {
    public static void main(String[] args) {
        PrinterOnly printerOnly = new BasicPrinter();
        printerOnly.print();

        MultiFunctionPrinter multiFunctionPrinter = new AdvancedPrinter();
        multiFunctionPrinter.print();
        multiFunctionPrinter.scan();
        multiFunctionPrinter.fax();
    }
}
