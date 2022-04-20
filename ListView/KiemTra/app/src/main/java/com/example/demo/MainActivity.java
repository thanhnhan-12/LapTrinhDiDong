package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSinhVien;
    ArrayList<SinhVien> arraySinhVien;
    SinhVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new SinhVienAdapter(this, R.layout.thongtinsv, arraySinhVien);
        lvSinhVien.setAdapter(adapter);
    }

    private void AnhXa() {
        lvSinhVien = (ListView) findViewById(R.id.listviewSinhVien);
        arraySinhVien = new ArrayList<>();

        arraySinhVien.add(new SinhVien("1911505310242", "Nguyễn Thành Nhân", "121LTDD02", R.drawable.sinhvien));

    }
}