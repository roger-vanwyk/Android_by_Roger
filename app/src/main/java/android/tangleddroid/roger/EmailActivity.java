package android.tangleddroid.roger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity {

//    Initiate EditText Views
    EditText editTextRecipient, editTextSubject, editTextMessage;
    Button sendEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

//        Find and connect the Views
        editTextRecipient = findViewById(R.id.editTextTextEmailAddress);
        editTextSubject = findViewById(R.id.editTextTextEmailSubject);
        editTextMessage = findViewById(R.id.editTextTextEmailMessage);
        sendEmailButton = findViewById(R.id.sendEmailButton);

        sendEmailButton.setOnClickListener(arg0 -> emailRoger());
    }

    private void emailRoger() {
        String to = editTextRecipient.getText().toString();
        String subject = editTextSubject.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Choose an email app"));
    }
}