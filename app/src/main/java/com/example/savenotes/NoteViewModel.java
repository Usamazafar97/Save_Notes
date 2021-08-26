package com.example.savenotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    void update(Note note){
        noteRepository.update(note);
    }

    void delete(Note note){
        noteRepository.delete(note);
    }

    void insert(Note note){
        noteRepository.insert(note);
    }

    void deleteAll(){
        noteRepository.deleteAllNotes();
    }

    LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
