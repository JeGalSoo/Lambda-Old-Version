package product;

import common.UtilServiceImpl;
import lombok.Getter;

public class ProductServiceImpl implements ProductService{
    @Getter
    private static ProductService instance = new ProductServiceImpl();

    private ProductServiceImpl() {
    } //디폴트 생성자를 막음

    @Override
    public int createRandompno() {
        return 0;
    }

    @Override
    public String createRandomName() {
        return UtilServiceImpl.getInstance().createRandomName();
    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글","엔비디아","메타","삼성","LG","애플"};
        return companies[UtilServiceImpl.getInstance().createRandomInteger(0, 5)];
    }

    @Override
    public int createRandomPrice() {
        return UtilServiceImpl.getInstance().createRandomInteger(10,100);
    }
}
