package vn.edu.ntu.nguyennamduong.recycleview59cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import vn.edu.ntu.nguyennamduong.controller.ICartController;
import vn.edu.ntu.nguyennamduong.model.Product;

import java.util.List;

public class Shopping_Activity extends AppCompatActivity {

    TextView txtShoppingCart;
    ICartController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_);
        controller = (ICartController) getApplication();
        addViews();
    }
    private void addViews(){
        txtShoppingCart = findViewById(R.id.txtCart);
        displayShoppingCart();
    }

    private void displayShoppingCart(){
        List<Product> shoppingCart;
        shoppingCart = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();
        for(Product p:shoppingCart){
            builder.append(p.getName())
                    .append("\t\t\t")
                    .append(p.getPrice())
                    .append(" VND\n");
        }
        if(builder.toString().length()>0)
            txtShoppingCart.setText(builder.toString());
        else txtShoppingCart.setText("Không có");
    }
}
