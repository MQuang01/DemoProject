import view.ProductView;

public class ShopApplication {
    private ProductView productView;


    public ShopApplication() {
        productView = new ProductView();
        productView.launcher();
    }


    public static void main(String[] args) {
        ShopApplication shopApplication = new ShopApplication();
    }
}