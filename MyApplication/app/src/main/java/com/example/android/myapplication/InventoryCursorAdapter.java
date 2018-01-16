package com.example.android.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ceoyi on 12/28/2017.
 */

public class InventoryCursorAdapter extends CursorAdapter {

    private CatalogActivity activity;

    public InventoryCursorAdapter(CatalogActivity context, Cursor c) {
        super(context, c, 0);
        this.activity = context;
    }

    /**
     * This method binds the inventory data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current inventory can be set on the name TextView
     * in the list item layout.
     */


    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.product_name);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        ImageView sale = (ImageView) view.findViewById(R.id.sale);
        ImageView image = (ImageView) view.findViewById(R.id.image_view);


        String name = cursor.getString(cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME));
        final int quantity = cursor.getInt(cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITY));
        String price = cursor.getString(cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE));

        image.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_IMAGE))));

        nameTextView.setText(name);
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText(price);

        final long id = cursor.getLong(cursor.getColumnIndex(InventoryContract.InventoryEntry._ID));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickOnViewItem(id);
            }
        });

        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickOnSale(id,
                        quantity);
            }
        });
    }
}




