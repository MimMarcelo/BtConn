package com.mimmarcelo.btconntest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.mimmarcelo.btconn.BluetoothManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Constants
    private final int TURN_ON = 1;
    private BluetoothManager bluetoothManager;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothManager = BluetoothManager.getBluetoothManager(this);

        txtStatus = findViewById(R.id.txtStatus);

        AppCompatButton btn = findViewById(R.id.btnTurnOn);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btnTurnOff);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btnShowMac);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btnShowDeviceName);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(bluetoothManager.isActived()){
            setStatus("Bluetooth on");
        }
        else {
            setStatus("Bluetooth off");
        }
    }

    private void setStatus(String message){
        txtStatus.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTurnOn:
                bluetoothManager.turnOn(TURN_ON);
                setStatus("asking for permission...");
                break;
            case R.id.btnTurnOff:
                bluetoothManager.turnOff();
                setStatus("Bluetooth off");
                break;
//            case R.id.btnShowMac:
//                setStatus("MAC: " + bluetoothManager.getMac());
//                break;
            case R.id.btnShowDeviceName:
                setStatus("Device name: " + bluetoothManager.getDeviceName());
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case TURN_ON:
                if(bluetoothManager.isActived()){
                    setStatus("Bluetooth on");
                }
                else{
                    setStatus("Bluetooth off");
                }
                break;
        }
    }
}
