package vn.edu.ntu.nguyennamduong.controller;

import java.util.List;

import vn.edu.ntu.nguyennamduong.model.Product;

public interface ICartController {
    List<Product> getAllProducts();
    public boolean addToCart (Product p);
    public List<Product> getShoppingCart();
    public void clearShoppingCart();
}
