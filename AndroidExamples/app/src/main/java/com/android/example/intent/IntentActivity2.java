package com.android.example.intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.example.R;

public class IntentActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CustomTest1 test1 =  (CustomTest1) getIntent().getExtras().getSerializable("serial");
        if(test1 != null){
            Log.e("tag","test1 name: "+test1.name+" age: "+test1.age);
        }

        CustomTest2 test2 = getIntent().getExtras().getParcelable("parcle");
        if(null != test2){
            Log.e("tag","test2 name: "+test2.name+" age: "+test2.age);
        }

    }

}
