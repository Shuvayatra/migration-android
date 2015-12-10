package com.yipl.nrna.domain.util;

/**
 * Created by julian on 12/9/15.
 */
public class MyConstants {
    public static final class API{
        public static final String LATEST_CONTENT = "latest";
    }

    public static final class Adapter{
        public static final int TYPE_QUESTION = 0;
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_VIDEO = 2;
        public static final int TYPE_TEXT = 3;
    }

    public static final class Extras{
        public static final String KEY_QUESTION = "key_question";
    }

    public static class DATABASE{

        public static String TYPE_TEXT = " TEXT ";
        public static String TYPE_LONG = " INTEGER ";
        public static String COMMA = ", ";

        public static class DBINFO{
            public static Integer DB_VERSION = 1;
            public static String DATABASE_NAME = "nrna-database.db";
        }

        public static class TABLE_POST{

            public static String TABLE_NAME = "tbl_post";
            public static String COLUMN_ID = "id";
            public static String COLUMN_UPDATED_AT = "updated_date";
            public static String COLUMN_CREATED_AT = "created_date";
            public static String COLUMN_DATA = "data";
            public static String COLUMN_TYPE = "text";
            public static String COLUMN_LANGUAGE = "language";
            public static String COLUMN_TAGS = "tag";
            public static String COLUMN_SOURCE = "source";
            public static String COLUMN_DESCRIPTION = "description";
            public static String COLUMN_TITLE = "title";

            public static String CREATE_TABLE_POST = "CREATE TABLE "+ TABLE_NAME + " ( "+
                    COLUMN_ID + " STRING PRIMARY KEY, " +
                    COLUMN_UPDATED_AT + TYPE_LONG + COMMA +
                    COLUMN_CREATED_AT + TYPE_LONG + COMMA +
                    COLUMN_DATA + TYPE_TEXT + COMMA +
                    COLUMN_TYPE + TYPE_TEXT + COMMA +
                    COLUMN_LANGUAGE + TYPE_TEXT + COMMA +
                    COLUMN_TAGS + TYPE_TEXT + COMMA +
                    COLUMN_SOURCE + TYPE_TEXT + COMMA +
                    COLUMN_DESCRIPTION + TYPE_TEXT + COMMA +
                    COLUMN_TITLE + TYPE_TEXT +
                    " );";
        }

        public static class Question{

            public static String TABLE_NAME = "tbl_question";

            public static String COLUMN_ID = "id";
            public static String COlUMN_UPDATED_AT = "updated_date";
            public static String COLUMN_CREATED_AT = "created_date";
            public static String COLUMN_TAGS = "tags";
            public static String COLUMN_LANGUAGE = "language";
            public static String COLUMN_QUESTION = "question";
        }
    }
}