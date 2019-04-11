package com.mimmarcelo.btconntest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.mimmarcelo.btconn.BluetoothManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BluetoothManager bluetoothManager;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothManager = BluetoothManager.getBluetoothManager();

        txtStatus = findViewById(R.id.txtStatus);

        AppCompatButton btn = findViewById(R.id.btnTurnOn);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btnTurnOff);
        btn.setOnClickListener(this);
    }

    private void setStatus(String message){
        txtStatus.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTurnOn:
                setStatus("Bluetooth on");
                break;
            case R.id.btnTurnOff:
                setStatus("Bluetooth off");
                break;
        }
    }
}
