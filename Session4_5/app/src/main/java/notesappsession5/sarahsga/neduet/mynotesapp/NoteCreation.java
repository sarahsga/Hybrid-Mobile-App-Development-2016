package notesappsession5.sarahsga.neduet.mynotesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class NoteCreation extends AppCompatActivity {

    EditText note_header;
    EditText note_content;
    ImageButton button_addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_creation);

        note_header = (EditText) findViewById(R.id.editText_noteHeader);
        note_content = (EditText) findViewById(R.id.editText_noteContent);
        button_addNote = (ImageButton) findViewById(R.id.imageBtn_addNote);
        button_addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("header", note_header.getText().toString());
                intent.putExtra("content", note_content.getText().toString());
                setResult(MyApp.RES_ADD_NOTE_BTN, intent);
                Toast.makeText(getApplicationContext(),"Note Created", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
        note_header = (EditText) findViewById(R.id.editText_noteHeader);
        note_content = (EditText) findViewById(R.id.editText_noteContent);
    }
}
