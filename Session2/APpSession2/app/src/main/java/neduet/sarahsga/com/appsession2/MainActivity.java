package neduet.sarahsga.com.appsession2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button myButton;
    EditText message_editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        message_editText =(EditText) findViewById(R.id.editText_typeMessage);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void handleBtnClick_sarah (View view) {
        String str =  message_editText.getText().toString();
        textView.setText(str);
    }
}
