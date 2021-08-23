package com.mat.android.androidmeteoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCityName;
    private LinearLayout linearLayoutNotConnexion;
    private LinearLayout linearLayoutConnexion;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCityName = (TextView)findViewById(R.id.textviewCity);
        Toast.makeText(this, textViewCityName.getText(), Toast.LENGTH_SHORT).show();

        /**
         * Connexion test
         */
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        linearLayoutNotConnexion = (LinearLayout)findViewById(R.id.linearlayoutnotconnexion);
        linearLayoutConnexion = (LinearLayout)findViewById(R.id.linearlayoutconnexion);

        if(networkInfo != null && networkInfo.isConnected()){
            Log.d("TAG", "Connexion ok");
            linearLayoutConnexion.setVisibility(View.VISIBLE);
            linearLayoutNotConnexion.setVisibility(View.INVISIBLE);
        } else {
            Log.d("TAG", "Pas de connexion");
            linearLayoutConnexion.setVisibility(View.INVISIBLE);
            linearLayoutNotConnexion.setVisibility(View.VISIBLE);
        }

        /*********************************************************/

        /**
         * Life's cycle
         */

        Log.d("TAG", "MainActivity : onCreate()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "MainActivity : onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "MainActivity : onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "MainActivity : onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "MainActivity : onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "MainActivity : onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "MainActivity : onDestroy()");
    }

    public void buttonHandle1(View view) {

        Toast.makeText(this, "Click button 1", Toast.LENGTH_SHORT).show();
    }

    public void buttonHandle2(View view) {

        Toast.makeText(this, "Click button 2", Toast.LENGTH_SHORT).show();
    }

    public void buttonHandle3(View view) {

        editTextMessage = (EditText)findViewById(R.id.edit_text_message);
        System.out.println("LE MESSAGE : " + editTextMessage.getText());
        Toast.makeText(this, "Click button 3", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
        intent.putExtra("msg", editTextMessage.getText());
        startActivity(intent);
    }
}