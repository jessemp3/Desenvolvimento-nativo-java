package com.nativo.mybooks.repository;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nativo.mybooks.entity.BookEntity;

@Database(
        entities = {BookEntity.class},
        version = 1
)
public abstract class BookDataBase extends RoomDatabase {
    private static final String NAME = "book_database";
    private static BookDataBase instace;

    public static BookDataBase getInstance(Context context) {
        synchronized ( BookDataBase.class) {
            if (instace == null) {
                instace = Room.databaseBuilder(context, BookDataBase.class, NAME)
                        .build();
            }
        }
        return instace;
    }
}
