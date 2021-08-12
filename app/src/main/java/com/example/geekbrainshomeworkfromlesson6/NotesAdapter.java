package com.example.geekbrainshomeworkfromlesson6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private final CardSource dataSource;
    private OnNoteClickListener listener;
    private OnNoteClickListener longListener;

    public void setListener(@Nullable OnNoteClickListener listener) {
        this.listener = listener;
    }

    public void setLongListener(@Nullable OnNoteClickListener longListener) {
        this.longListener = longListener;
    }

    public NotesAdapter(CardSource dataSource) {
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
        holder.bind(dataSource.getCardData(position));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView note;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            note = itemView.findViewById(R.id.textView);
            note.setOnClickListener(v -> {
                listener.onNoteClick(getAdapterPosition());
            });
            note.setOnLongClickListener(v -> {
                longListener.onNoteClick(getAdapterPosition());
                return false;
            });
        }

        public void bind(CardData cardData) {
            note.setText(cardData.getNote());
        }
    }

    interface OnNoteClickListener {
        void onNoteClick(int position);
    }
}
