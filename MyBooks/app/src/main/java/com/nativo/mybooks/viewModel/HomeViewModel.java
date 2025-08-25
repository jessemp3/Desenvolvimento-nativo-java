package com.nativo.mybooks.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nativo.mybooks.entity.BookEntity;
import com.nativo.mybooks.repository.BookRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private BookRepository bookRepository = BookRepository.getInstance(getApplication().getApplicationContext());
    private final MutableLiveData<List<BookEntity>> _books = new MutableLiveData<>();
    public final MutableLiveData<List<BookEntity>> books = _books;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getBooks() {
        _books.setValue(bookRepository.getBooks());
    }

    public void toggleFavoriteStatus(int id){
        bookRepository.toggleFavoriteStatus(id);
        getBooks();
    }
}