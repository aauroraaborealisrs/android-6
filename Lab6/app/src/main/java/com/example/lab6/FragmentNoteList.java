/*package com.example.lab6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentNoteList extends Fragment {
    private List<Note> notes = new ArrayList<>();
    private NoteAdapter.OnNoteClickListener onNoteClickListener;

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setOnNoteClickListener(NoteAdapter.OnNoteClickListener listener) {
        this.onNoteClickListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new NoteAdapter(
                notes,
                note -> {
                    // Обработка клика по заметке
                    Log.d("FragmentNoteList", "Clicked on note: " + note.getTitle());
                },
                (note, isChecked) -> {
                    // Обработка клика по чекбоксу
                    Log.d("FragmentNoteList", "Checkbox clicked: " + note.getTitle() + ", isChecked: " + isChecked);
                }
        ));

    }
}*/


package com.example.lab6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentNoteList extends Fragment {
    private List<Note> notes = new ArrayList<>();
    private NoteAdapter.OnNoteClickListener onNoteClickListener;

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setOnNoteClickListener(NoteAdapter.OnNoteClickListener listener) {
        this.onNoteClickListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new NoteAdapter(notes, onNoteClickListener)); // Передаем слушатель
    }
}

