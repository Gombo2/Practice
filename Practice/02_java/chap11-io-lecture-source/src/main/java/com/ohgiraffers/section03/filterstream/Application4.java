package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {

        MemberDTO[] memArr = new MemberDTO[50];
        memArr[0] = new MemberDTO("user01", "pass01", "홍길동",
                "hong123@gmail.com", 25, '남');
        memArr[1] = new MemberDTO("user02", "pass02", "유관순",
                "korea31@gmail.com", 16, '여');
        memArr[2] = new MemberDTO("user03", "pass03", "강감찬",
                "kang@gmail.com", 38, '남');

        File ObjFile = new File("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt");
        ObjectOutputStream oos = null;
        try {
            if(!ObjFile.exists()){
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt"
                                )
                        )
                );
            } else {
                oos = new MyOutput(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true
                                )
                        )
                );
            }

//            oos.writeObject(memArr[0]);
            for (int i = 0; i < 3; i++) {           // 온전한 객체만 들어가도록 실체가 있는 수만큼 반복
                oos.writeObject(memArr[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        MemberDTO[] newMemArr = new MemberDTO[memArr.length];

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                        new FileInputStream(
                                "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt"
                        )
                    )
                );

//            newMemArr[0] = (MemberDTO)ois.readObject();
            int index = 0;
            while(true) {
                if(index == newMemArr.length) break;
                newMemArr[index++] = (MemberDTO) ois.readObject();
            }

        } catch (EOFException e) {
            System.out.println("회원 정보 읽기 완료!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* 설명. 출력 및 입력까지 잘 완료되었는지 새로운 배열의 회원 정보 확인 */
        for (MemberDTO mem : newMemArr) {
            if(mem == null) break;
            System.out.println(mem);
        }
    }
}
