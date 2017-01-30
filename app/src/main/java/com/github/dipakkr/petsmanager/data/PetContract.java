package com.github.dipakkr.petsmanager.data;

import android.provider.BaseColumns;

/**
 * Created by deepak on 30-01-2017.
 */

public final class PetContract {

    private PetContract() {
    }

    private static final class PetEntry implements BaseColumns {


        private static final String TABLE_NAME = "pets";
        private static final String ID = BaseColumns._ID;
        private static final String COLUMN_PET_NAME = "name";
        private static final String COLUMN_PET_BREED = "breed";
        private static final String COLUMN_PET_GENDER = "gender";

        public final static String COLUMN_PET_WEIGHT = "weight";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
