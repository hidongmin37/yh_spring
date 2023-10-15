package helloweb.itemService.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter @Setter
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // integer를 쓰는 이유는 0이라도 들어가야되는데, 널값이 들어갈 수도 있어서
    private Integer quantity;

    public Item() {

    }

    public Item( String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
