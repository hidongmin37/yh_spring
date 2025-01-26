package com.basic.java.oop;

public class Account {
    int balance = 0;

    void deposit(int amount) {
        balance += amount;
        System.out.println(amount + " 이 입금되었습니다.");
        System.out.println("잔고 => " + balance);
    }

    void withdraw(int amount) {
        if (balance < amount){
            System.out.println( "잔고부족");
            System.out.println("잔고 => " + balance);
        }else{
            balance -= amount;
            System.out.println(amount + " 이 출금되었습니다.");
            System.out.println("잔고 => " + balance);
        }
    }
    void printBalance(){
        System.out.println("잔고 => " + balance);
    }
}
