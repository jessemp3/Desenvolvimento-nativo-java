package com.nativo.mybooks.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nativo.mybooks.entity.BookEntity;
import com.nativo.mybooks.repository.BookRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private BookRepository bookRepository = new BookRepository();
    private final MutableLiveData<List<BookEntity>> _books = new MutableLiveData<>();
    public final MutableLiveData<List<BookEntity>> books = _books;

    public void getBooks() {
        _books.setValue(bookRepository.getBooks());
    }
}