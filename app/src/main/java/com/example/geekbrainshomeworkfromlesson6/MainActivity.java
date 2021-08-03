package com.example.geekbrainshomeworkfromlesson6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        NotesFragment notesFragment = new NotesFragment();
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
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
                Toast toast3 = Toast.makeText(getApplicationContext(),
                        "Add new note later...", Toast.LENGTH_SHORT);
                toast3.show();
                return true;
            case R.id.action_edit:
                Toast toast4 = Toast.makeText(getApplicationContext(),
                        "Edit note later...", Toast.LENGTH_SHORT);
                toast4.show();
                return true;
            case R.id.action_delete:
                Toast toast5 = Toast.makeText(getApplicationContext(),
                        "Delete note later...", Toast.LENGTH_SHORT);
                toast5.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}