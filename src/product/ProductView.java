package product;


import java.util.ArrayList;
import java.util.List;

public class ProductView {
    public static void main(String[] args) {
        List<Product> pd = new ArrayList<>();
        ProductService pdo = ProductServiceImpl.getInstance();
        for(int i=0; i<6;i++){
            pd.add(Product.builder()
                    .pno(pdo.createRandompno())
                    .name(pdo.createRandomName())
                    .company(pdo.createRandomCompany())
                    .price(pdo.createRandomPrice())
                    .build());
        }
        pd.forEach(i->{
            System.out.println(i.toString());
        });
    }
}
