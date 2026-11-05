package com.example.sem4practic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ImobilAdapter extends BaseAdapter {
    private List<Imobil> imobile;
    private Context ctx;
    private int layoutResource;

    public ImobilAdapter(List<Imobil> imobile, Context ctx, int layoutResource) {
        this.imobile = imobile;
        this.ctx = ctx;
        this.layoutResource = layoutResource;
    }

    @Override
    public int getCount() {
        return imobile.size();
    }

    @Override
    public Object getItem(int i) {
        return imobile.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        convertView = inflater.inflate(layoutResource, parent, false);

        Imobil imobil = (Imobil) getItem(position);

        TextView tvNume = convertView.findViewById(R.id.tvNumeItem);
        TextView tvDetalii = convertView.findViewById(R.id.tvDetaliiItem);
        TextView tvFacilitati = convertView.findViewById(R.id.tvFacilitatiItem);

        tvNume.setText(imobil.getNume());
        tvDetalii.setText(imobil.getDetalii());
        tvFacilitati.setText(imobil.getFacilitati());

        return convertView;
    }
}