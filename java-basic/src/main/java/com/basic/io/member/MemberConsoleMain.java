package com.basic.io.member;

import com.basic.io.member.impl.FilMemberRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {

    private static final MemberRepository memberRepository = new FilMemberRepository();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 회원가입 | 2. 회원목록 | 3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerMember(scanner);
                    break;
                case 2:
                    displayMembers();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
            }

        }
    }
    private static void registerMember(Scanner scanner) throws IOException {
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("나이: ");
        String age = scanner.nextLine();

        Member member = new Member(id, name, Integer.parseInt(age));
        memberRepository.add(member);
        System.out.println("회원가입 완료");

    }

    private static void displayMembers() {
        List<Member> all = memberRepository.findAll();
        System.out.println("회원 목록");
        for (Member member : all) {
            System.out.println(member);
        }
    }
}
