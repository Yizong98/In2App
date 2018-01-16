package com.example.android.myapplication;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ceoyi on 12/28/2017.
 */

public final class InventoryContract {
    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.myapplication";
    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.inventorys/inventorys/ is a valid path for
     * looking at inventory data. content://com.example.android.inventorys/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_INVENTORIES = "inventories";

    private InventoryContract() {
    }

    /**
     * Inner class that defines constant values for the inventorys database table.
     * Each entry in the table represents a single inventory.
     */
    public static final class InventoryEntry implements BaseColumns {

        /**
         * The content URI to access the inventory data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_INVENTORIES);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of inventorys.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORIES;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single inventory.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORIES;

        /**
         * Name of database table for inventory
         */
        public final static String TABLE_NAME = "inventories";

        /**
         * Unique ID number for the inventory (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the inventory.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_INVENTORY_NAME = "name";

        public final static String COLUMN_INVENTORY_PRICE = "price";


        public final static String COLUMN_INVENTORY_QUANTITY = "quantity";

        public final static String COLUMN_INVENTORY_IMAGE = "image";

        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
        public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";


    }

}
