package vn.edu.ntu.nguyennamduong.recycleview59cntt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.ntu.nguyennamduong.controller.ICartController;
import vn.edu.ntu.nguyennamduong.model.Product;

import java.util.List;

public class Shopping_Activity extends AppCompatActivity {

    TextView txtShoppingCart;
    ICartController controller;
    Button btnDelete, btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_);
        controller = (ICartController) getApplication();
        addViews();
    }

    private void addViews() {
        txtShoppingCart = findViewById(R.id.txtCart);
        btnDelete = findViewById(R.id.btnCancle);
        btnBuy = findViewById(R.id.btnOK);
        displayShoppingCart();
        deleteShoppingCart();
        buy();
    }

    private void displayShoppingCart() {
        List<Product> shoppingCart;
        shoppingCart = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();
        for (Product p : shoppingCart) {
            builder.append(p.getName())
                    .append("\t\t\t")
                    .append(p.getPrice())
                    .append(" VND\n");
        }
        if (builder.toString().length() > 0)
            txtShoppingCart.setText(builder.toString());
        else txtShoppingCart.setText("Không có mặt hàng trong giỏ hàng!");
    }

    private void deleteShoppingCart() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.clearShoppingCart();
                txtShoppingCart.setText("Không có mặt hàng trong giỏ hàng!");
            }
        });
    }

    private void buy(){
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.clearShoppingCart();
                txtShoppingCart.setText("Không có mặt hàng trong giỏ hàng!");
                Intent intent = new Intent(Shopping_Activity.this, Buy_Activity.class);
                startActivity(intent);

            }
        });
    }

}