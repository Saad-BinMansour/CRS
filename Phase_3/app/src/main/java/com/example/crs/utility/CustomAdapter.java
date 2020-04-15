package com.example.crs.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;
import com.example.crs.R;
import com.example.crs.activities.BookmarkActivity;
import com.example.crs.database.ComputerDBHandler;
import com.example.crs.model.item.Item;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {
    private Context myContext;
    private int resource;
    private List<Item> itemList;
    private ComputerDBHandler computerDBHandler;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Item> itemList) {
        super(context, resource, itemList);

        this.myContext = context;
        this.resource = resource;
        this.itemList = itemList;
        this.computerDBHandler = new ComputerDBHandler(context, null);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        @SuppressLint("ViewHolder") View view = inflater.inflate(resource, null);
        final Item item = itemList.get(position);
        final ImageButton bookmarkButton = view.findViewById(R.id.bookmark);

        // If the item is bookmarked, show its status
        if (computerDBHandler.isBookmark(item.getId())) {
            bookmarkButton.setImageDrawable(ResourcesCompat.getDrawable(myContext.getResources(),
                    R.drawable.inbookmark_ic, null));
        }

        ImageView productImage = view.findViewById(R.id.product_img);
        TextView productName = view.findViewById(R.id.product_name);
        TextView productPrice = view.findViewById(R.id.product_price);

        // Loads an image from the link into the image view
        Glide.with(myContext)
                .load(item.getImageLink())
                .fitCenter()
                .into(productImage);

        // Sets the product's name
        productName.setText(item.toString());

        // sets the product's price
        productPrice.setText(String.valueOf(item.getPrice()));

        // Opens the item's website
        view.findViewById(R.id.sourceimage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(item.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                myContext.startActivity(intent);
            }
        });

        /* If the bookmark icon is clicked and it's bookmarked sets the icon to its default state
         * and remove the mark from the database, and vice versa.
         */
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (computerDBHandler.isBookmark(item.getId())) {
                    Drawable drawable =
                            ResourcesCompat.getDrawable(myContext.getResources(),
                                    R.drawable.tobookmark_ic, null);
                    computerDBHandler.removeBookmark(item.getId());
                    bookmarkButton.setImageDrawable(drawable);
                    if (myContext instanceof BookmarkActivity) {
                        clear();
                        addAll(computerDBHandler.getBookmarked());
                        notifyDataSetChanged();
                    }
                } else {
                    Drawable drawable =
                            ResourcesCompat.getDrawable(myContext.getResources(),
                                    R.drawable.inbookmark_ic, null);

                    computerDBHandler.setBookmarked(item.getId());
                    bookmarkButton.setImageDrawable(drawable);
                }
            }
        });

        return view;
    }
}
