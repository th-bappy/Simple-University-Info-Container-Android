package com.example.toptenvarsity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity implements View.OnClickListener {

    private Button sendbutton, clearbutton;
    private EditText nameeditetext, massageedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendbutton = (Button) findViewById(R.id.feedbacksendid);
        clearbutton = (Button) findViewById(R.id.feedbackclearid);

        nameeditetext = (EditText) findViewById(R.id.feedbacknameId);
        massageedittext = (EditText) findViewById(R.id.feedbackmassageId);

        sendbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        try {
            String name = nameeditetext.getText().toString();
            String massage = massageedittext.getText().toString();

            if (v.getId() == R.id.feedbacksendid) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tanvir15-7706@diu.edu.bd"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback From Common Disease App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Massage: " + massage);

                startActivity(Intent.createChooser(intent, "Feedback With"));
            } else {
                nameeditetext.setText("");
                massageedittext.setText("");
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Exception:"+ e, Toast.LENGTH_SHORT).show();
        }

    }
}