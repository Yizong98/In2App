package com.example.android.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.myapplication.InventoryContract.InventoryEntry;
/**
 * Created by ceoyi on 12/28/2017.
 */

public class InventoryCursorAdapter extends CursorAdapter {

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView quantityTextView = (TextView) view.findViewById(R.id.summary);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        ImageView image = (ImageView) view.findViewById(R.id.image_view);

        // Find the columns of pet attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_INVENTORY_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_INVENTORY_QUANTITY);
        int imageColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_INVENTORY_IMAGE);
        int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_INVENTORY_PRICE);
        // Read the pet attributes from the Cursor for the current pet
        String InventoryName = cursor.getString(nameColumnIndex);
        int InventoryQuantity = cursor.getInt(quantityColumnIndex);
        int InventoryPrice = cursor.getInt(priceColumnIndex);
        image.setImageURI(Uri.parse(cursor.getString(imageColumnIndex)));




        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(InventoryName);
        quantityTextView.setText(String.valueOf(InventoryQuantity));
        priceTextView.setText(String.valueOf(InventoryPrice));
    }

}
