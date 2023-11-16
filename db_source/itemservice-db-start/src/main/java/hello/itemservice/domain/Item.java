package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "item") // 테이블명이랑 객체명이 같다면 생략해줘도 됨.
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// db에서 값을 증가
    private Long id;

    @Column(name = "item_name", length = 10)// 테이블 명이랑 컬럼명이 같다면 비워둬도 됨=> price, quantity
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
