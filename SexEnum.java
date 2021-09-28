package com.pl.jmotyka;

import java.util.Scanner;

public enum SexEnum {
        MALE,
        FEMALE;

    static SexEnum chooseSex() {
        SexEnum sex = null;
        System.out.print("Choose sex: [1] MALE [2] FEMALE. Choice: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int sexChoice = scanner.nextInt();
            sex = null;
            switch (sexChoice) {
                        case 1:
                            sex = SexEnum.MALE;
                            break;
                        case 2:
                            sex = SexEnum.FEMALE;
                            break;
                    }
        } catch (Exception e) {
            System.out.println("ooops, sth went wrong! Default sex has been set (MALE)!");
            sex = SexEnum.MALE;
        }
        return sex;
    }
}