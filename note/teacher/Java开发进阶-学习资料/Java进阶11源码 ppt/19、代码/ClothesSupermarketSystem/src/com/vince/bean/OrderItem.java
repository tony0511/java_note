package com.vince.bean;

import java.io.Serializable;

/**
 * Created by vince on 2017/7/11.
 */
public class OrderItem implements Serializable{
    private static final long  serialVersionUID = 1L;
    private int itemId;
    private Clothes clothes;//商品
    private int shoppingNum;
    private float sum;//购买金额

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", clothes=" + clothes +
                ", shoppingNum=" + shoppingNum +
                ", sum=" + sum +
                '}';
    }
}
