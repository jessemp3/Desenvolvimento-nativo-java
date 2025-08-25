package com.nativo.mybooks.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.nativo.mybooks.entity.BookEntity;
import com.nativo.mybooks.ui.helper.DataBaseContance;

import java.util.ArrayList;
import java.util.List;

public class BookDataBaseHelper extends
        SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "book_database";

    public BookDataBaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // scripts para a criação das tabelas / banco


        String createBookTable = "CREATE TABLE " + DataBaseContance.Book.TABLE_NAME + " (" +
                DataBaseContance.Book.Columns.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataBaseContance.Book.Columns.TITLE + " TEXT NOT NULL, " +
                DataBaseContance.Book.Columns.AUTHOR+ " TEXT NOT NULL, " +
                DataBaseContance.Book.Columns.GENRE+ " TEXT NOT NULL, " +
                DataBaseContance.Book.Columns.FAVORITE + "INTEGER NOT NULL );";

        db.execSQL(createBookTable);


        insertBooks(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // scripts para atualização do banco
    }


    private void insertBooks(SQLiteDatabase db) {
        List<BookEntity> books = getInitialBooks();
        for (BookEntity book : books) {
            ContentValues values = new ContentValues();
            values.put(DataBaseContance.Book.Columns.TITLE, book.getTitle());
            values.put(DataBaseContance.Book.Columns.AUTHOR, book.getAuthor());
            // Converte boolean para inteiro
            values.put(DataBaseContance.Book.Columns.FAVORITE, book.isFavorite() ? 1 : 0);
            values.put(DataBaseContance.Book.Columns.GENRE, book.getGenre());

            // Insere o livro na tabela
            db.insert(DataBaseContance.Book.TABLE_NAME, null, values);
        }
    }

    private List<BookEntity> getInitialBooks() {
        List<BookEntity> initialBooks = new ArrayList<>();
        initialBooks.add(new BookEntity(1, "To Kill a Mockingbird", "Harper Lee", true, "Ficção"));
        initialBooks.add(new BookEntity(2, "Dom Casmurro", "Machado de Assis", false, "Romance"));
        initialBooks.add(new BookEntity(3, "O Hobbit", "J.R.R. Tolkien", true, "Fantasia"));
        initialBooks.add(new BookEntity(4, "Cem Anos de Solidão", "Gabriel García Márquez", false, "Romance"));
        initialBooks.add(new BookEntity(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", false, "Fantasia"));
        initialBooks.add(new BookEntity(6, "Crime e Castigo", "Fiódor Dostoiévski", false, "Ficção policial"));
        initialBooks.add(new BookEntity(7, "Frankenstein", "Mary Shelley", false, "Terror"));
        initialBooks.add(new BookEntity(8, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", false, "Fantasia"));
        initialBooks.add(new BookEntity(9, "Neuromancer", "William Gibson", false, "Cyberpunk"));
        initialBooks.add(new BookEntity(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"));
        initialBooks.add(new BookEntity(11, "Drácula", "Bram Stoker", false, "Terror"));
        initialBooks.add(new BookEntity(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"));
        initialBooks.add(new BookEntity(13, "Harry Potter e a Câmara Secreta", "J.K. Rowling", false, "Fantasia"));
        initialBooks.add(new BookEntity(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"));
        initialBooks.add(new BookEntity(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"));
        initialBooks.add(new BookEntity(16, "It: A Coisa", "Stephen King", false, "Terror"));
        initialBooks.add(new BookEntity(17, "Moby Dick", "Herman Melville", true, "Aventura"));
        initialBooks.add(new BookEntity(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"));
        initialBooks.add(new BookEntity(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"));
        initialBooks.add(new BookEntity(20, "Os Miseráveis", "Victor Hugo", false, "Romance"));
        return initialBooks;
    }
}
