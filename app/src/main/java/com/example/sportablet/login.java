package com.example.sportablet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import java.util.ArrayList;
public class login extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<User> Users;

    @Override
    protected void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Users = new ArrayList<>();

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (login TEXT, password TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        while (query.moveToNext()) {
            String login = query.getString(0);
            String password = query.getString(1);
            Users.add(new User(login, password));
        }
        query.close();
        db.close();

        Button act_change;
        act_change = (Button) findViewById(R.id.act_change);
        act_change.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, reg.class);
        startActivity(i);
    }

    private Button Login;
    private EditText username;
    private EditText password;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.reg_username);
        password = (EditText) findViewById(R.id.reg_password);
    }

    public void Login(View view) {
        EditText username = findViewById(R.id.reg_username);
        EditText password = findViewById(R.id.reg_password);
        String Log = username.getText().toString();
        String Pass = password.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        if (Log.equals("") || Pass.equals("")) {
            alert.setTitle("Так нельзя");
            alert.setMessage("заполните все йомайо");
            alert.show();
            return;
        }
        boolean found = false;
        for (User item : login.Users) {
            if (Log.equals(item.login)) {
                found = true;
                alert.setMessage("Успешно йоу");
                alert.setTitle("ОК");
                alert.setPositiveButton("Log in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        login.this.finish();
                        Intent intent = new Intent(login.this, menu.class);
                        startActivity(intent);
                    }
                });
                alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        login.this.finish();
                        Intent intent = new Intent(login.this, menu.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }
    }
}
