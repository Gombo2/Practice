package com.ohgiraffers.list.dto;

public class BookDTO implements Comparable<BookDTO> {
        private int number;
        private String title;
        private String author;
        private int price;

    public BookDTO() {
    }

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    /* 설명.
    *   우리가 원하는 필드의 오름차순 또는 내림차순을 할 수 있다.
    *   필드가 n개면 총(n*2)가지의 정렬 기준을 가질 수 있다.(각각 ASC 또는 DESC)
    *   정렬은 compareTo() 메소드가 반환하는 int형의 부호에 따라 정해지게 되므로 오름차순과 내림차순은
    *   부호만 달리 되도록 하면 된다.
    *   (해당 필드가 String형일 경우는 String에 정의 된 compareTo() 메소드를 활용한다.
    * */
    @Override
    public int compareTo(BookDTO o) {

        /* 설명. 가격에 대한 오름차순*/
//        return this.price - o.price;  // 오름차순

        /* 설명. 가격에 대한 내림차순*/
//        return -(this.price - o.price);
//        return o.price - this.price;

        /* 설명. 책 제목에 대한 오름차순 */
//        return this.title.compareTo(o.title);

        /* 설명. 책 제목에 대한 내림차순 */
//        return -this.title.compareTo(o.title);
        return o.title.compareTo(this.title);
    }
}
