package com.bmpl.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button visibleButton, pairDeviceButton;
    Switch aSwitch;
    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> bluetoothDevice;
    //Set is an interface will remove duplication
    //BluetoothDevice will get the paired device information

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();//get the bluetooth driver info. start or stop

        listView = (ListView)findViewById(R.id.listView);
        visibleButton = (Button)findViewById(R.id.visibleButton);
        pairDeviceButton = (Button)findViewById(R.id.pairDeviceButton);
        aSwitch = (Switch) findViewById(R.id.bluetoothSwitch);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(bluetoothAdapter==null){
                    Toast.makeText(MainActivity.this, "Driver not available", Toast.LENGTH_SHORT).show();
                } else if(!bluetoothAdapter.isEnabled()){
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                } else {

                }
            }
        });
        visibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,2000);
                startActivity(intent);
            }
        });

        pairDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList arrayList = new ArrayList();
                ArrayAdapter arrayAdapter;
                bluetoothDevice = bluetoothAdapter.getBondedDevices();
                for(BluetoothDevice device: bluetoothDevice)
                {
                        arrayList.add(device.getName());
                }

                arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);

                listView.setAdapter(arrayAdapter);
            }
        });
    }
}