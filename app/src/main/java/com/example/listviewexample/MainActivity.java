package com.example.listviewexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Person> peopleAL;
    ListView lvPeople;
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createListView();

    }

    protected void createListView()
    {
        Person person1 = new Person("Yuval", "Hevlin", 13);
        Person person2 = new Person("Raz", "Hevlin", 10);
        Person person3 = new Person("Maya", "Hevlin", 47);

        peopleAL = new ArrayList<Person>();
        peopleAL.add(person1);
        peopleAL.add(person2);
        peopleAL.add(person3);

        personAdapter = new PersonAdapter(this, 0, peopleAL);
        lvPeople = findViewById(R.id.lvPeople);
        lvPeople.setAdapter(personAdapter);
        lvPeople.setOnItemClickListener(this);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int i = data.getIntExtra("IndexInList", 0);
        Person person = peopleAL.get(i);
        person.setName(data.getStringExtra("Name"));
        person.setFname(data.getStringExtra("FName"));
        person.setAge(data.getIntExtra("Age", 0));
        personAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Person person = peopleAL.get(i);
        Intent intent = new Intent(this, EditRecordActivity.class);
        intent.putExtra("Name", person.getName() );
        intent.putExtra("FName", person.getFname() );
        intent.putExtra("Age", person.getAge() );
        intent.putExtra( "IndexInList", i );
        startActivityForResult(intent, 0 );
    }
}