package com.devfest.app.devfest;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Bind(R.id.input_name) EditText _name;
    @Bind(R.id.input_email) EditText _email;
    @Bind(R.id.input_password) EditText _password;
    @Bind(R.id.btn_signup) AppCompatButton button;


    @OnClick(R.id.btn_signup) void submit() {
        createAccount();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
    }


    private void createAccount() {
        button.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account");


        String name = _name.getText().toString();
        String email = _email.getText().toString();
        String password = _password.getText().toString();

        String details = String.format("Name: %s\nEmail: %s\nPassword: %s", name, email, password);

        Toast.makeText(getBaseContext(), "Registration Details: " + details, Toast.LENGTH_SHORT).show();

        progressDialog.show();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onSignupSuccess();
                progressDialog.dismiss();
            }
        }, 3000);
    }

    private void onSignupSuccess() {
        button.setEnabled(true);
        Toast.makeText(getBaseContext(), "Account created successfully", Toast.LENGTH_LONG).show();
    }
}
