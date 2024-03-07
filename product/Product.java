package product;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})
public class Product {
    private int id;
    private int pno;
    private String name;
    private String company;
    private int price;

    @Builder(builderClassName = "builder")
    public Product(int pno, String name, String company, int price) {
        this.pno = pno;
        this.name = name;
        this.company = company;
        this.price = price;
    }
}
