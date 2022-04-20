package com.example.intentdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imgGoc, imgQuestion;
    int Request_Code_Image = 123;
    String HinhGoc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGoc = (ImageView) findViewById(R.id.imgGoc);
        imgQuestion = (ImageView) findViewById(R.id.imgQuestion);

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        // Trộn mảng
        Collections.shuffle(arrayName);
        HinhGoc = arrayName.get(5);
        int idHinh = getResources().getIdentifier(arrayName.get(5), "drawable", getPackageName());
        imgGoc.setImageResource(idHinh);

        imgQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, ImageActivity.class), Request_Code_Image);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Request_Code_Image && resultCode == RESULT_OK && data != null) {
            String hinhnhan = data.getStringExtra("HinhChon");
            int idHinhnhan = getResources().getIdentifier(hinhnhan, "drawable", getPackageName());
            imgQuestion.setImageResource(idHinhnhan);
            // So sánh theo hình
            if(HinhGoc.equals(hinhnhan)) {
                Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
                // Đổi hình gốc
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        // Trộn mảng
                        Collections.shuffle(arrayName);
                        HinhGoc = arrayName.get(5);
                        int idHinh = getResources().getIdentifier(arrayName.get(5), "drawable", getPackageName());
                        imgGoc.setImageResource(idHinh);
                    }
                }.start();
            }
            else {
                Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuReload) {
            // Trộn mảng
            Collections.shuffle(arrayName);
            HinhGoc = arrayName.get(5);
            int idHinh = getResources().getIdentifier(arrayName.get(5), "drawable", getPackageName());
            imgGoc.setImageResource(idHinh);
        }

        return super.onOptionsItemSelected(item);
    }
}