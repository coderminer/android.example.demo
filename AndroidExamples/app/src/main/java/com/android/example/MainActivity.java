package com.android.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.example.assets.AssetsActivity;
import com.android.example.intent.IntentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mIntent;
    private Button mAssets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntent = (Button)findViewById(R.id.intent);
        mAssets = (Button)findViewById(R.id.assets);

        mIntent.setOnClickListener(this);
        mAssets.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.intent:{
                intent.setClass(this,IntentActivity.class);
            }
                break;
            case R.id.assets:{
                intent.setClass(this, AssetsActivity.class);
            }
                break;


        }
        startActivity(intent);
    }
}
