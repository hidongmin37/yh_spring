package lang.enumeration.ex_test;

import java.util.Objects;
import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner grade = new Scanner(System.in);
        System.out.println("당신의 등급을 입력하세요 [GUEST, LOGIN, ADMIN]: ");
        String str = grade.nextLine();
        AuthGrade authGrade = AuthGrade.valueOf(str.toUpperCase());
        System.out.println("당신의 등급은 " + authGrade.getDescription() +"입니다");

    }
}
