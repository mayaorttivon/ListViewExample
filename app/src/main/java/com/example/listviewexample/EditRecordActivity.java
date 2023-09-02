package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditRecordActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etFName;
    EditText etAge;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        init();
    }

    protected void init()
    {
        etName = findViewById(R.id.etName);
        etFName = findViewById(R.id.etFName);
        etAge = findViewById(R.id.etAge);
        Intent intent = getIntent();
        etName.setText(intent.getStringExtra("Name"));
        etFName.setText(intent.getStringExtra("FName"));
        etAge.setText(String.valueOf( intent.getIntExtra("Age", 0) ) );
        btnSave = findViewById( R.id.btnSave );
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Name", etName.getText().toString() );
        intent.putExtra("FName", etFName.getText().toString() );
        intent.putExtra("Age", Integer.valueOf( etAge.getText().toString() ) );
        intent.putExtra( "IndexInList", getIntent().getIntExtra("IndexInList",0 ) );
        setResult(RESULT_OK, intent );
        finish();
    }
}