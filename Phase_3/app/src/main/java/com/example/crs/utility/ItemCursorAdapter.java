package com.example.crs.utility;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crs.R;
import com.example.crs.database.ComputerDBHandler;
import com.example.crs.model.item.Item;
import com.google.gson.Gson;

public class ItemCursorAdapter extends CursorAdapter {
    public ItemCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.product_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        byte[] itemByte = cursor.getBlob(ComputerDBHandler.Column.COMPUTER_DATA.getColumnNumber());
        Item item = new Gson().fromJson(String.valueOf(itemByte), Item.class);

        ImageView productImage = view.findViewById(R.id.product_img);
        TextView productName = view.findViewById(R.id.product_name);
        TextView productPrice = view.findViewById(R.id.product_price);

        Glide.with(context)
                .load(item.getImageLink())
                .fitCenter()
                .into(productImage);
        productName.setText(item.getName());
        productPrice.setText(item.getPrice() + "");
    }
}
