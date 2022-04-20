package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    private Context context;
    private int Layout;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        Layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(Layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.txtTen);
        TextView txtMota = (TextView) view.findViewById(R.id.txtThongTin);
        TextView txtLop = (TextView) view.findViewById(R.id.txtLopHP);
        ImageView imageHinh = (ImageView) view.findViewById(R.id.imgHinh);

        SinhVien sinhVien = sinhVienList.get(i);
        txtTen.setText(sinhVien.getHoTen());
        txtLop.setText(sinhVien.getLopHP());
        txtMota.setText(sinhVien.getMasv());
        imageHinh.setImageResource(sinhVien.getHinh());

        return view;
    }
}
