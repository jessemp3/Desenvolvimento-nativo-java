package com.nativo.mybooks.repository;

import android.content.Context;

import com.nativo.mybooks.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<BookEntity> books = new ArrayList<>();

    private static BookRepository instance;

    private final BookDataBaseHelper dataBase;


    private BookRepository(Context context) {
        dataBase = new BookDataBaseHelper(context);
        dataBase.getWritableDatabase();
    }

    //padrão singleton
    public static BookRepository getInstance(Context context) {
        // o "synchronized" evita que duas threads acessem o método ao mesmo tempo
       synchronized (BookRepository.class){
            if(instance == null) {
                instance = new BookRepository(context);
            }
        }
        return instance;
    }



    public List<BookEntity> getBooks() {
        return books;
    }

    public List<BookEntity> getFavoriteBooks() {
        List<BookEntity> favorites = new ArrayList<>();

        for (BookEntity book : books) {
            if (book.isFavorite()) {
                favorites.add(book);
            }
        }
        return favorites;

    }

    public BookEntity getBookById(int id) {
        BookEntity book = null;

        for (BookEntity b : books) {
            if (b.getId() == id) {
                book = b;
                break;
            }
        }
        return book;
    }

    public void toggleFavoriteStatus(int id) {
        for (BookEntity book : books) {
            if (book.getId() == id) {
                book.setFavorite(!book.isFavorite());
                break;
            }
        }
    }

    public boolean delete(int id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == id){
                books.remove(i);
                return true;
            }
        }
        return false;
    }



}
