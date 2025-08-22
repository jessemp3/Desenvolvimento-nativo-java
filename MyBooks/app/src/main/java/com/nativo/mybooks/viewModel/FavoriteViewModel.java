package com.nativo.mybooks.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nativo.mybooks.entity.BookEntity;
import com.nativo.mybooks.repository.BookRepository;

import java.util.List;

public class FavoriteViewModel extends ViewModel {
    private BookRepository bookRepository = BookRepository.getInstance();

    private final MutableLiveData<List<BookEntity>> _books = new MutableLiveData<>();
    public final MutableLiveData<List<BookEntity>> books = _books;

    public void getBooks() {
        _books.setValue(bookRepository.getFavoriteBooks());
    }

    public void toggleFavoriteStatus(int id){
        bookRepository.toggleFavoriteStatus(id);
        getBooks();
    }
}