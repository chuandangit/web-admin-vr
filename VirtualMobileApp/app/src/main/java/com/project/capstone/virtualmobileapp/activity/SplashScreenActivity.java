package com.project.capstone.virtualmobileapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.project.capstone.virtualmobileapp.R;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new ProcessStartAsyncTask().execute();
    }

    private class ProcessStartAsyncTask extends AsyncTask<Void,Void,Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            SharedPreferences sharedPreferences = getSharedPreferences("localData", MODE_PRIVATE);
            int userId = -1;
            try {
                userId = sharedPreferences.getInt("userId",-1);
            } catch (Exception e){
            }

            if (userId == -1)
                return false;
            else
                return true;
        }

        @Override
        protected void onPostExecute(Boolean s) {
            super.onPostExecute(s);
            if (s)
                startMainActivity();
            else
                startMainActivity();
        }
    }

    private void startMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void startSignInActivity() {
        Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(intent);
        finish();
    }
}
