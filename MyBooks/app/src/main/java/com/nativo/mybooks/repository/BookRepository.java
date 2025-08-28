package com.nativo.mybooks.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nativo.mybooks.entity.BookEntity;
import com.nativo.mybooks.ui.helper.DataBaseContance;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;

    private final BookDataBaseHelper dataBase;


    private BookRepository(Context context) {
        dataBase = new BookDataBaseHelper(context);
        dataBase.getWritableDatabase();
    }

    //padrão singleton
    public static BookRepository getInstance(Context context) {
        // o "synchronized" evita que duas threads acessem o método ao mesmo tempo
        synchronized (BookRepository.class) {
            if (instance == null) {
                instance = new BookRepository(context);
            }
        }
        return instance;
    }


    public List<BookEntity> getBooks() {
        List<BookEntity> books = new ArrayList<>();

        // Obtém uma instância de leitura do banco de dados
        SQLiteDatabase db = dataBase.getReadableDatabase();

        // Query para selecionar todos os livros da tabela
        Cursor cursor = db.query(
                DataBaseContance.Book.TABLE_NAME,  // Nome da tabela
                null,  // Seleciona todas as colunas
                null,  // Sem filtro de linhas
                null,  // Sem argumentos
                null,  // Sem agrupamento
                null,  // Sem filtro de ordenação
                null   // Sem limite
        );

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.TITLE));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.AUTHOR));
                // Converte de volta para booleano
                boolean fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.FAVORITE)) == 1;
                String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.GENRE));

                // Adiciona o livro à lista
                books.add(new BookEntity(id, title, author, fav, genre));

                // Continua enquanto houver mais registros
            } while (cursor.moveToNext());
        }

        // Fecha o cursor e banco de dados após o uso
        cursor.close();
        db.close();

        // Retorna a lista de livros
        return books;
    }

    public List<BookEntity> getFavoriteBooks() {
        List<BookEntity> books = new ArrayList<>();

        // Obtém uma instância de leitura do banco de dados
        SQLiteDatabase db = dataBase.getReadableDatabase();

        // Query para selecionar todos os livros da tabela
        Cursor cursor = db.query(
                DataBaseContance.Book.TABLE_NAME,  // Nome da tabela
                null,  // Seleciona todas as colunas
                DataBaseContance.Book.Columns.FAVORITE + " = ?",
                new String[]{"1"},
                null,  // Sem agrupamento
                null,  // Sem filtro de ordenação
                null   // Sem limite
        );

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.TITLE));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.AUTHOR));
                // Converte de volta para booleano
                boolean fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.FAVORITE)) == 1;
                String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.GENRE));

                // Adiciona o livro à lista
                books.add(new BookEntity(id, title, author, fav, genre));

                // Continua enquanto houver mais registros
            } while (cursor.moveToNext());
        }

        // Fecha o cursor e banco de dados após o uso
        cursor.close();
        db.close();

        // Retorna a lista de livros
        return books;

    }

    public BookEntity getBookById(int id) {
        BookEntity book = null;

        // Obtém uma instância de leitura do banco de dados
        SQLiteDatabase db = dataBase.getReadableDatabase();

        // Query para selecionar todos os livros da tabela
        Cursor cursor = db.query(
                DataBaseContance.Book.TABLE_NAME,  // Nome da tabela
                null,  // Seleciona todas as colunas
                DataBaseContance.Book.Columns.ID + " = ?",
                new String[]{String.valueOf(id)},
                null,  // Sem agrupamento
                null,  // Sem filtro de ordenação
                null   // Sem limite
        );

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.TITLE));
            String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.AUTHOR));
            // Converte de volta para booleano
            boolean fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.FAVORITE)) == 1;
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseContance.Book.Columns.GENRE));

            // Adiciona o livro à lista
            book = new BookEntity(id, title, author, fav, genre);

            // Continua enquanto houver mais registros
        }

        // Fecha o cursor e banco de dados após o uso
        cursor.close();
        db.close();

        // Retorna a lista de livros
        return book;
    }

    public void toggleFavoriteStatus(int id) {
        BookEntity book = getBookById(id);
        SQLiteDatabase db = dataBase.getWritableDatabase();

        int newFavoriteStatus = book.isFavorite() ? 0 : 1;

        ContentValues values = new ContentValues();
        values.put(DataBaseContance.Book.Columns.FAVORITE, newFavoriteStatus);


        db.update(DataBaseContance.Book.TABLE_NAME,
                values,
                DataBaseContance.Book.Columns.ID + " = ?",
                new String[]{String.valueOf(id)}
                );

    }

    public boolean delete(int id) {
        SQLiteDatabase db = dataBase.getWritableDatabase();

        int rowsDeleted = db.delete(DataBaseContance.Book.TABLE_NAME,
                DataBaseContance.Book.Columns.ID + " = ?",
                new String[]{String.valueOf(id)});

        return rowsDeleted > 0;
    }
}
