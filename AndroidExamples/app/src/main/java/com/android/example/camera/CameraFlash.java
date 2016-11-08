package com.android.example.camera;

import android.content.Context;
import android.content.pm.PackageManager;

import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.android.example.R;

public class CameraFlash extends AppCompatActivity {

    private CameraManager cameraManager;
    private String cameraId;
    private boolean isFlashOn = false;

    private Camera camera;

    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_flash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aSwitch = (Switch)findViewById(R.id.switch_w);
        cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                flashOn();
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    flashOn();
                }else {

                }
            }
        });
    }

    private void flashOn(){
        try{
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                camera = Camera.open();
                Camera.Parameters p = camera.getParameters();
                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(p);
                camera.startPreview();
            }else {
                cameraId = cameraManager.getCameraIdList()[0];
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    cameraManager.setTorchMode(cameraId,true);
                }else {

                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void flashOff(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            camera.stopPreview();
            camera.release();
            camera = null;
        }else {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                try {
                    cameraManager.setTorchMode(cameraId,false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{

            }
        }

    }

    private boolean isCameraFlashSupport(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

}
