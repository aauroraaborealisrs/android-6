package com.example.lab6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentNoteDetails extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("FragmentNoteDetails", "Фрагмент создан");
        Bundle args = getArguments();
        if (args != null) {
            Note note = args.getParcelable("note");
            if (note != null) {
                Log.d("FragmentNoteDetails", "Получены данные: " + note.getTitle());
                TextView noteContent = view.findViewById(R.id.noteContent);
                noteContent.setText(note.getContent());
            } else {
                Log.e("FragmentNoteDetails", "Ошибка: Данные не получены");
            }
        } else {
            Log.e("FragmentNoteDetails", "Ошибка: Аргументы не переданы");
        }
    }

}
