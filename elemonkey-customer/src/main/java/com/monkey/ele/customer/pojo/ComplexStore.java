package com.monkey.ele.customer.pojo;

import com.monkey.ele.customer.controller.StoreController;

public class ComplexStore {

    private String storeid;
    private String storeName;
    private StoreInformation storeInformation;


    public ComplexStore(String storeid, String storeName,StoreInformation storeInformation) {
        this.storeid = storeid;
        this.storeName = storeName;
        this.storeInformation = storeInformation;
    }



    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public StoreInformation getStoreInformation() {
        return storeInformation;
    }

    public void setStoreInformation(StoreInformation storeInformation) {
        this.storeInformation = storeInformation;
    }
}
