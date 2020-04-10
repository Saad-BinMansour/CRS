package com.example.crs.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.crs.R;
import com.example.crs.model.item.Item;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {
    private Context myContext;
    private int resource;
    private List<Item> itemList;

    CustomAdapter(@NonNull Context context, int resource, @NonNull List<Item> itemList) {
        super(context, resource, itemList);

        this.myContext = context;
        this.resource = resource;
        this.itemList = itemList;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        @SuppressLint("ViewHolder") View view = inflater.inflate(resource, null);
        Item item = itemList.get(position);

        ImageView productImage = view.findViewById(R.id.product_img);
        TextView productName = view.findViewById(R.id.product_name);
        TextView productPrice = view.findViewById(R.id.product_price);

        Glide.with(myContext)
                .load(item.getImageLink())
                .fitCenter()
                .into(productImage);
        productName.setText(item.getName());
        productPrice.setText(item.getPrice() + "");

        view.findViewById(R.id.gototext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
