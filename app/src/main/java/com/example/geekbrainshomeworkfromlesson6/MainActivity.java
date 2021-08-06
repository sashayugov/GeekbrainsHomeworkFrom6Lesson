package com.example.geekbrainshomeworkfromlesson6;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    NotesFragment notesFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        notesFragment = new NotesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes, notesFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Soon we will be search...", Toast.LENGTH_SHORT);
                toast1.show();
                return true;
            case R.id.action_favorite:
                Toast toast2 = Toast.makeText(getApplicationContext(),
                        "Probably not so favourite", Toast.LENGTH_SHORT);
                toast2.show();
                return true;
            case R.id.action_add:
                notesFragment.cardSource.addCardData(new CardData("Note", "Details"));
                notesFragment.notesAdapter.notifyItemInserted(notesFragment.cardSource.size() - 1);
                notesFragment.recyclerView.scrollToPosition(notesFragment.cardSource.size() - 1);
                return true;
            case R.id.action_edit:
                Toast toast4 = Toast.makeText(getApplicationContext(),
                        "Edit note later...", Toast.LENGTH_SHORT);
                toast4.show();
                return true;
            case R.id.action_delete:
                notesFragment.cardSource.clearCardData();
                notesFragment.notesAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}