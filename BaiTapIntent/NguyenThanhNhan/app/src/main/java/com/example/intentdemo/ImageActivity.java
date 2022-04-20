package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class ImageActivity extends Activity {

    TableLayout myTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        myTable = (TableLayout) findViewById(R.id.tableLayoutImage);

        int row = 5;
        int column = 2;

        // Trộn mảng
        Collections.shuffle(MainActivity.arrayName);

        // Tạo dòng
        for (int i = 1; i <= row; i++) {
            TableRow tableRow = new TableRow(this);
            // Tạo cột
            for (int j = 1; j <= column; j++) {
                ImageView imageView = new ImageView(this);

                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());

                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);
                final int position = column * (i - 1) + (j - 1);
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(position), "drawable", getPackageName());
                imageView.setImageResource(idHinh);
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("HinhChon", MainActivity.arrayName.get(position));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });

            }
            // add tablerow vào table
            myTable.addView(tableRow);
        }

    }
}