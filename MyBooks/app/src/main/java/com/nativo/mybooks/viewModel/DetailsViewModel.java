package com.nativo.mybooks.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nativo.mybooks.entity.BookEntity;
import com.nativo.mybooks.repository.BookRepository;

public class DetailsViewModel extends AndroidViewModel {
    private final BookRepository bookRepository = BookRepository.getInstance(getApplication().getApplicationContext());

    private final MutableLiveData<BookEntity> _book = new MutableLiveData<>();
    public final MutableLiveData<BookEntity> book = _book;

    private final MutableLiveData<Boolean> _bookDeleted = new MutableLiveData<>();
    public final MutableLiveData<Boolean> bookDeleted = _bookDeleted;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
    }

    public void getBookById(int id) {
        _book.setValue(bookRepository.getBookById(id));
    }

    public void toggleFavoriteStatus(int id) {
        bookRepository.toggleFavoriteStatus(id);
    }

    public void delete(int id){
        _bookDeleted.setValue(bookRepository.delete(id));
    }
}