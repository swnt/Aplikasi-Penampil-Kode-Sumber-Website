package com.example.siswanto.aplikasipenampilkodesumberwebsite;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.DisconnectCause;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    static TextView myText, inputan;
    private Spinner spinnerx;
    String protocol;

    ConnectivityManager myConnManager;
    NetworkInfo myInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.myResult);
        inputan= (TextView) findViewById(R.id.inputan);

        protocol = "";
        spinnerx=(Spinner)findViewById(R.id.spinnr);
        spinnerx.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }

    public void doSomething(View view) {
        myText.setText("");
        c1 = new ConnectInternetTask(this);
        c1.execute(protocol.toString() + inputan.getText().toString());

        myConnManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManager.getActiveNetworkInfo();

        if(myInfo != null && myInfo.isConnected()){
            Toast.makeText(this, "Tunggu Sejenak", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Sambungkan Dengan Internet", Toast.LENGTH_SHORT).show();
        }
    }



    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinnerx.getSelectedItem());
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinnerx.getSelectedItem()))) {
                protocol = parent.getItemAtPosition(pos).toString();
            }else{
                protocol = parent.getItemAtPosition(pos).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    }
}
