package com.example.lab34;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText time;
    Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
time = findViewById(R.id.timer);
start_button = findViewById(R.id.start);

start_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        send_time(view);
    }
});
    }

    private void send_time(View view) {
        Intent intent = new Intent(this, count.class);
        EditText time = (EditText) findViewById(R.id.timer);//Is this necesary?
        String tiempo = time.getText().toString();
        intent.putExtra("time", tiempo); //putExtra() method adds the EditText's value to the intent
        startActivity(intent);

    }
}
