package com.example.seethepaireddevices_bluetoothchatapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ListView paired_devices;
    Button show_button;
    BluetoothAdapter mybluetoothadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paired_devices=findViewById(R.id.paired_devicesList);
        show_button=findViewById(R.id.show_paireddevices);
        mybluetoothadapter=BluetoothAdapter.getDefaultAdapter();
        exeButton();

    }

    private void exeButton() {
        show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<BluetoothDevice> bt=mybluetoothadapter.getBondedDevices();
                String [] strings=new String[bt.size()];
                int index=0;
                if (bt.size()>0)
                {
                    for (BluetoothDevice bluetoothDevice:bt)
                    {
                        strings[index]=bluetoothDevice.getName();
                        index++;
                    }
                    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,strings);
                    paired_devices.setAdapter(arrayAdapter);
                }
            }
        });
    }
}