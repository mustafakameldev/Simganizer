package com.mka.simganizer.SetData;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mka.simganizer.AuthActivity;
import com.mka.simganizer.R;

public class SetDataCompanyActivity extends AppCompatActivity implements SetManagerFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data_company);

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
            finish();
        }  else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
            SetManagerFragment fragment = new SetManagerFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
        }


    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
