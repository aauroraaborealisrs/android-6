package com.example.lab6;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        Note note = getIntent().getParcelableExtra("note");
        if (note == null) {
            Log.d("NoteDetailsActivity", "Нифига не пришло: " + note.getTitle());
            finish();
            return;
        }

        Log.d("NoteDetailsActivity", "Получена заметка: " + note.getTitle());

        FragmentNoteDetails detailsFragment = new FragmentNoteDetails();

        Bundle bundle = new Bundle();
        bundle.putParcelable("note", note);
        detailsFragment.setArguments(bundle);

        //Получает FragmentManager, который управляет фрагментами.
        //Начинает транзакцию с помощью beginTransaction().
        //Заменяет содержимое контейнера с id="detailsFragmentContainer" на фрагмент detailsFragment.
        //Применяет изменения с помощью commit().

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detailsFragmentContainer, detailsFragment)
                .commit();

    }
}
