package com.monkey.ele.customer.pojo;

public class Cart {


    public static final class CartSetting{
        public static final long Cart_EXPIRES_TIME = 15;
    }

    private String productId;
    private int num;
//
//
//
//    public String getStoreId() {
//        return storeId;
//    }
//
//    public void setStoreId(String storeId) {
//        this.storeId = storeId;
//    }


    public Cart() {
    }

    public Cart(String productId, int num) {
        this.productId = productId;
        this.num = num;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
