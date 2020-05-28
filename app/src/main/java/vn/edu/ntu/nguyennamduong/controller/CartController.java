package vn.edu.ntu.nguyennamduong.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyennamduong.model.Product;

public class CartController extends Application implements ICartController
{
    List<Product> productList = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    public CartController() {
        productList.add(new Product("Chuối Đà Nha Trang", 25000, "Chuối to, chín vàng"));
        productList.add(new Product("Sầu riêng Khánh Sơn", 95000, "SR cơm vàng, hạt lép"));
        productList.add(new Product("Khoai lang", 35000, "Khoai lang theo tiêu chuẩn Việt Gap"));
        productList.add(new Product("Xoài cát Hòa Lộc", 55000, "Xoài cát Hòa Lộc loại 1"));
        productList.add(new Product("Nho không hạt", 65000, "Nho Mỹ không hạt loại 1"));
        productList.add(new Product("Táo", 65000, "Táo Chile"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public boolean addToCart(Product p) {
        if(shoppingCart.contains(p))
            return false;
        shoppingCart.add(p);
        return true;
    }

    @Override
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
