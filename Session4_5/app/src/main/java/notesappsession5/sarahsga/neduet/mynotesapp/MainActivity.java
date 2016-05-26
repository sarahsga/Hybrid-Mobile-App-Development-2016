package notesappsession5.sarahsga.neduet.mynotesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    String[] myArray = {"Apple", "Orange", "Mango"};
    ArrayAdapter adapter;
    Button btn_addNote;
    ArrayList<String> list_headers;
    ArrayList<String> list_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_headers = new ArrayList();
        list_content = new ArrayList();

        btn_addNote = (Button) findViewById(R.id.btn_addNote);
        btn_addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NoteCreation.class);
                startActivityForResult(intent, MyApp.REQ_ADD_NOTE_BTN);
            }
        });
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NotesDisplay.class);
                String h = list_headers.get(position);
                String c = list_content.get(position);
                intent.putExtra("header_clicked", h);
                intent.putExtra("content_clicked", c);
                startActivity(intent);
            }
        });
        adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_custom_layout, list_headers);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data == null) {
            Log.e( MyApp.TAG, "data is null");
        } else {
            Log.e( MyApp.TAG, "data is not null");

        }

        if(requestCode == MyApp.REQ_ADD_NOTE_BTN && resultCode == MyApp.RES_ADD_NOTE_BTN && data != null) {
            Toast.makeText( getApplicationContext(), "djsfk j", Toast.LENGTH_SHORT).show();
            Bundle b = data.getExtras();
            String header = (String)b.get("header");
            Log.w(MyApp.TAG, "header " + header);
            String content = (String) b.get("content");
            Log.w(MyApp.TAG, "content " + content);
            list_headers.add(header);
            list_content.add(content);
            adapter.notifyDataSetChanged();;
        }

    }


}
