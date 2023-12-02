package view;

import utils.*;
import model.*;
import service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ValidateUtils.*;

public class ProductView {


    private ProductService productService;

    public ProductView(){
        productService = new ProductService();
        if (!FileUtils.checkFileExists(Config.PATH_FILE_NAME)) {
            productService.init();
        }else{
            productService.setCurrentId();
        }
    }

    public void launcher(){
        do {
            System.out.println("Menu quản lý sản phẩm: ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm ");
            System.out.println("3. Xóa sản phâm ");
            System.out.println("4. Sắp xếp sản phẩm: ");
            System.out.println("5. Tìm kiếm sản phẩm:");

            System.out.println("Moi nhập");
            int actionMenu = Integer.parseInt(sc.nextLine());
            switch (actionMenu){
                case 1:{
                    showProducts();
                    break;
                }
                case 2:
                {
                    createProduct();
                    break;
                }
                case 3:
                {
                    removeProductById();
                    break;
                }
            }
        }while (true);

    }

    public void removeProductById() {
        long id = getLong("Nhập id muốn xóa: ");
        productService.removeProduct(id);

        showProducts();
    }

    public void createProduct() {
        String pName = getString("Nhập tên sản phẩm: ");
        String pDescription = getString("Nhập mô tả sản phẩm: ");
        float price = getFloat("Nhập giá sản phẩm: ");
        long idUser = getLong("Nhập mã nhân viên tạo: ");

        List<User> users = new ArrayList<>();
        FileUtils.readFileUser(users, Config.PATH_FILE_NAME_USER);
        User user = null;
        for(User us : users){
            if(us.getId() == idUser){
                user = us;
                break;
            }
        }


        for (ECategory eCategory : ECategory.values()) {
            System.out.printf("Nhập %s | %s", eCategory.getId(), eCategory.getName());
        }
        long idECategory = getLong("");
        ECategory eCategory = ECategory.getBy(idECategory);

        Product p = new Product(pName, pDescription, price, user, eCategory, LocalDate.now());
        productService.addProduct(p);

        showProducts();
    }

    public void showProducts() {
        List<Product> products = productService.getAll();
        System.out.printf("%10s | %20s | %30s | %15s | %10s | %20s | %20s\n", "ID", "Name", "Description", "Price", "User", "Category", "Create at");
        for (Product p : products) {
            System.out.printf("%10s | %20s | %30s | %15s | %10s | %20s | %20s\n",
                    p.getId(), p.getpName(), p.getpDescription(), p.getPrice(), p.getUserCreated().getName(), p.geteCategory(),p.getCreateAt() );
        }
    }
}
