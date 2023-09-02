package com.example.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person>{

    Context context;
    List<Person> objects;
    TextView tvName;
    TextView tvFName;
    TextView tvAge;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //The layout inflater take an xml and turns it into a class of type "View".
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_layout, parent, false);

        //update each object with the data from our arraylist.
        Person person = objects.get(position);
        tvName = view.findViewById(R.id.tvName);
        tvName.setText(person.getName());
        tvFName = view.findViewById(R.id.tvFName);
        tvFName.setText(person.getFname());
        tvAge = view.findViewById(R.id.tvAge);
        tvAge.setText(String.valueOf(person.getAge()));

        //add on click listener for editing a record
       // view.setOnClickListener(this);
        return view;
    }

 /*   @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, EditRecordActivity.class);
        intent.putExtra("Name", tvName.getText().toString());
        ((Activity)context).startActivityForResult(intent, 0);
    }*/
}
