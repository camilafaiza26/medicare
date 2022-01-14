package com.example.medicare.Database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.medicare.Database.EntityClass;
import com.example.medicare.Database.EventDao;

@Database(entities = {EntityClass.class}, version = 1)
public abstract class DatabaseClass extends RoomDatabase {
    private static DatabaseClass INSTANCE;

    public abstract EventDao EventDao();

    public static DatabaseClass getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseClass.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    DatabaseClass.class,
                                    "product_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}