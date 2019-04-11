/**
 * File name: BluetoothManager
 * It is the interface between the client app and the Bluetooth library
 * It is responsible for control all Bluetooth sources
 */
package com.mimmarcelo.btconn;

public final class BluetoothManager {
    //Singleton pattern
    private static BluetoothManager bluetoothManager;

    //Singleton pattern
    private BluetoothManager(){

    }

    //Singleton pattern
    public static BluetoothManager getBluetoothManager() {
        if(bluetoothManager == null){
            bluetoothManager = new BluetoothManager();
        }
        return bluetoothManager;
    }
}
