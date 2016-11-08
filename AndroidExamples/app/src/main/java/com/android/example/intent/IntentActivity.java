package com.android.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.example.R;

import org.json.JSONObject;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSerial;
    private Button mParale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSerial = (Button)findViewById(R.id.serial);
        mSerial.setOnClickListener(this);

        mParale = (Button)findViewById(R.id.parel);
        mParale.setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this,IntentActivity2.class);
        switch (v.getId()){
            case R.id.serial: {
                CustomTest1 test1 = new CustomTest1();
                test1.name = "Kevin";
                test1.age = 12;
                Bundle b = new Bundle();
                b.putSerializable("serial",test1);
                intent.putExtras(b);
            }
                break;


            case R.id.parel:{
                CustomTest2 test2 = new CustomTest2();
                test2.age = 14;
                test2.name = "Jhon";
                Bundle b = new Bundle();
                b.putParcelable("parcle",test2);
                intent.putExtras(b);}
                break;

        }

        startActivity(intent);
    }
}
