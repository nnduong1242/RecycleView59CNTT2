package vn.edu.ntu.nguyennamduong.recycleview59cntt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import vn.edu.ntu.nguyennamduong.controller.ICartController;

public class Buy_Activity extends AppCompatActivity {
    ICartController controller;
    Button btnQuayLai;
    TextView txtNgayGiaoHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        controller = (ICartController) getApplication();
        addViews();
    }

    private void addViews()
    {
        btnQuayLai = findViewById(R.id.btnQuayLai);
        txtNgayGiaoHang = findViewById(R.id.txtNgay);
        QuayLai();
        NgayGiaoHang();
    }

    private void QuayLai(){
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buy_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void NgayGiaoHang(){
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        txtNgayGiaoHang.setText(formattedDate);
    }
}
