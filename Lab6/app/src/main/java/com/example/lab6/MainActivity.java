package com.example.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Настраиваем отступы для системных панелей
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Создаем список заметок
        List<Note> notes = Arrays.asList(
                new Note(1, "Note 1", "Описание заметки 1"),
                new Note(2, "Note 2", "Описание заметки 2"),
                new Note(3, "Note 3", "Описание заметки 3")
        );


        // Создаем фрагмент списка заметок
        FragmentNoteList noteListFragment = new FragmentNoteList();
        noteListFragment.setNotes(notes);

        // Инициализируем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Проверяем, планшет это или телефон
        if (findViewById(R.id.detailsFragmentContainer) != null) {

            Log.d("MainActivity", "Планшетный режим активирован.");
            // Планшет: отображаем список и фрагмент с деталями
            noteListFragment.setOnNoteClickListener(note -> {
                // Создаем фрагмент с деталями заметки
                FragmentNoteDetails detailsFragment = new FragmentNoteDetails();
                Bundle bundle = new Bundle();
                bundle.putParcelable("note", note); // Передаем объект Note через Bundle
                detailsFragment.setArguments(bundle);

                // Заменяем контейнер для деталей на новый фрагмент
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.detailsFragmentContainer, detailsFragment);
                transaction.commit();
            });

            // Отображаем список заметок в контейнере
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.listFragmentContainer, noteListFragment);
            transaction.commit();
        } else {
            Log.d("MainActivity", "Телефон: ");

            // Телефон: открываем новую активити для деталей
            noteListFragment.setOnNoteClickListener(note -> {
                Log.d("MainActivity", "Передаем Note: " + note.getTitle());
                Intent intent = new Intent(this, NoteDetailsActivity.class);
                intent.putExtra("note", note); // Передаем заметку в Intent
                startActivity(intent);
            });

            // Отображаем список заметок в основном контейнере
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.mainFragmentContainer, noteListFragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Toast.makeText(this, "Кнопка добавить нажата", Toast.LENGTH_SHORT).show();
            Log.d("MainActivity", "Кнопка добавить нажата");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
