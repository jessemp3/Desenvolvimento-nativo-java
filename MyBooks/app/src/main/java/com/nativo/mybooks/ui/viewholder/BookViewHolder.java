package com.nativo.mybooks.ui.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nativo.mybooks.databinding.ItemBookBinding;
import com.nativo.mybooks.entity.BookEntity;

public class BookViewHolder extends RecyclerView.ViewHolder {
    private final ItemBookBinding item;

    public BookViewHolder(@NonNull ItemBookBinding itemView) {
        super(itemView.getRoot());
        item = itemView;
    }

    public void bind(BookEntity book){
        item.textViewTitle.setText(book.getTitle());
    }
}
