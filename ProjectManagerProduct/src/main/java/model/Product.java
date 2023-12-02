package model;

import java.time.LocalDate;

public class Product {
    public static long currentId;
    private long id;
    private String pName;
    private String pDescription;
    private float price;

    private User userCreated;
    private ECategory eCategory;

    private LocalDate createAt;

    public Product(long id, String pName, String pDescription, float price, User userCreated, ECategory eCategory, LocalDate createAt) {
        this.id = id;
        this.pName = pName;
        this.pDescription = pDescription;
        this.price = price;
        this.userCreated = userCreated;
        this.eCategory = eCategory;
        this.createAt = createAt;
    }

    public Product(String pName, String pDescription, float price, User userCreated, ECategory eCategory, LocalDate createAt) {
        this.pName = pName;
        this.pDescription = pDescription;
        this.price = price;
        this.userCreated = userCreated;
        this.eCategory = eCategory;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        //ID,NAME,DESCRIPTION,PRICE,IDUSER,ECATEGORY,DATE
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.id, this.pName,
                this.pDescription, this.price, this.userCreated.getId(), this.eCategory, this.createAt);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public ECategory geteCategory() {
        return eCategory;
    }

    public void seteCategory(ECategory eCategory) {
        this.eCategory = eCategory;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
