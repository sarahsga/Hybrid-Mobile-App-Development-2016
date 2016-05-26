package notesappsession5.sarahsga.neduet.mynotesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotesDisplay extends AppCompatActivity {

    TextView header;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_display);

        header = (TextView) findViewById(R.id.textView_header);
        content = (TextView) findViewById(R.id.textView_content);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            String h = (String)b.get("header_clicked");
            String c = (String) b.get("content_clicked");
            header.setText(h);
            content.setText(c);
        }
    }
}
