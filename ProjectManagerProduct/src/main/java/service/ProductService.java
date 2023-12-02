package service;

import model.ECategory;
import model.ERole;
import model.Product;
import model.User;
import utils.DateUtils;
import utils.FileUtils;
import utils.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        FileUtils.readFileProduct(products, Config.PATH_FILE_NAME);
        return products;

    }

    public void init(){
        List<Product> products = new ArrayList<>();
        User user = new User(1L, "quangdang", "123123", ERole.ADMIN);

        products.add(new Product(++Product.currentId, "Iphone 11", "Iphone 11 64GB RED", 1000000f,
                user, ECategory.APPLE, DateUtils.parse("2023-10-09")));
        products.add(new Product(++Product.currentId, "Iphone 12", "Iphone 11 64GB RED", 1000000f,
                user, ECategory.APPLE, DateUtils.parse("2023-10-09")));
        products.add(new Product(++Product.currentId, "Iphone 13", "Iphone 11 64GB RED", 1000000f,
                user, ECategory.APPLE, DateUtils.parse("2023-10-09")));

        FileUtils.writeFile(products, Config.PATH_FILE_NAME);
    }
    public void setCurrentId(){
        Product.currentId = 4;
    }

    public void addProduct(Product pNew) {
        List<Product> products = getAll();
        pNew.setId(++Product.currentId);
        products.add(pNew);

        FileUtils.writeFile(products, Config.PATH_FILE_NAME);
    }

    public Product getById(long id){
        List<Product> products = getAll();
        for(Product p : products){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public void removeProduct(long id){
        List<Product> products = getAll();
        for (Product p : products){
            if(p.getId() == id){
                products.remove(p);
                break;
            }
        }

        FileUtils.writeFile(products, Config.PATH_FILE_NAME);
    }
}
