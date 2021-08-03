package com.example.geekbrainshomeworkfromlesson6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private String[] dataSource;

    public String[] getDataSource() {
        return dataSource;
    }

    private OnNoteClickListener listener;

    public void setListener(@Nullable OnNoteClickListener listener) {
        this.listener = listener;
    }

    public NotesAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        holder.getTextView().setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TextView getTextView() {
            return textView;
        }

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView.setOnClickListener(v -> {
                listener.onNoteClick(getAdapterPosition());
            });

        }
    }

    interface OnNoteClickListener {
        void onNoteClick(int position);
    }
}
