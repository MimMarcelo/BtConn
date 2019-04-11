/**
 * File name: BluetoothManager
 * It is the interface between the client app and the Bluetooth library
 * It is responsible for control all Bluetooth sources
 */
package com.mimmarcelo.btconn;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;

import java.util.Set;

public final class BluetoothManager {

    //Singleton pattern
    private static BluetoothManager bluetoothManager;

    private Activity activity;
    private BluetoothAdapter bluetoothAdapter;

    //Singleton pattern
    private BluetoothManager(){
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    /**
     * Creates or returns a BluetoothManager instance, and updates activity param
     * @param activity Instance from the BluetoothManager is called
     * @return BluetoothManager instance
     */
    public static BluetoothManager getBluetoothManager(Activity activity) {
        if(bluetoothManager == null){
            bluetoothManager = new BluetoothManager();
        }
        bluetoothManager.activity = activity;
        return bluetoothManager;
    }

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public void turnOn(int requestCode, Bundle options) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        this.activity.startActivityForResult(intent, requestCode, options);
    }

    public  void turnOn(int requestCode){
        turnOn(requestCode, null);
    }

    public void turnOff(){
        if(isActived()) {
            bluetoothAdapter.disable();
        }
    }

    public boolean isActived(){
        return  bluetoothAdapter.isEnabled();
    }

    public String getDeviceName(){
        return bluetoothAdapter.getName();
    }

    public Set<BluetoothDevice> getBondedDevices(){
        return bluetoothAdapter.getBondedDevices();
    }
}
