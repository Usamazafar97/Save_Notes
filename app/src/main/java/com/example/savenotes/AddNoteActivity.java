package com.example.savenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "TITLE";
    public static final String EXTRA_DESCRIPTION = "DESCRIPTION";
    public static final String EXTRA_PRIORITY = "PRIORITY";
    private EditText etTitle;
    private EditText etDescription;
    private NumberPicker numberPickerProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        numberPickerProperty = findViewById(R.id.number_picker_priority);

        numberPickerProperty.setMinValue(1);
        numberPickerProperty.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        setTitle("Add Note");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_notes:
                saveNote();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        int priority = numberPickerProperty.getValue();

        if (title.isEmpty() || description.isEmpty()){
            Toast.makeText(this, "Please enter title and description", Toast.LENGTH_SHORT).show();
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,description);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);
        finish();

    }
}