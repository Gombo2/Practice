package com.oghiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {
    private String cpu;
    private int hdd;
    private int ram;
    private String operatingSystem;

    public Computer() {
        super();
    }

    public Computer(String cpu, int hdd, int ram, String operatingSystem) {
        super(); //자동완성시 부모의 생성자 생략됨.
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    public Computer(String code, String brand, String name, int price, Date manufactureDate, String cpu, int hdd, int ram, String operatingSystem) {
        super(code, brand, name, price, manufactureDate);
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public int getRam() {
        return ram;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        /* computer의 필드값과 product의 필드값(toString())을 통해 다 출력가능 */
//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operatingSystem='" + operatingSystem + '\'' +
//                "} " + super.toString();
        /*getter를 통해 computer의 필드값과 product에서 특정 필드값만 출력 또한 가능*/
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram +
                ", operatingSystem='" + operatingSystem + '\'' +
                "} " + super.getCode() + super.getBrand();
    }
}
