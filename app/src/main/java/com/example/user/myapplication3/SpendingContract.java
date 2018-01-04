package com.example.user.myapplication3;

import android.provider.BaseColumns;

import static android.provider.Contacts.SettingsColumns.KEY;
import static java.sql.Types.NULL;
import static java.text.Collator.PRIMARY;

/**
 * Created by User on 3/1/2018.
 */

public class SpendingContract {
    public static final class SpendingEntry implements BaseColumns {

        public static final String TABLE_NAME = "SpendingRecord";
        public static final String COL_AMOUNT = "Amount";
        public static final String COL_REMARKS = "Remarks";

    }

}
