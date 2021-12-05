
package com.technic.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText confirm_pwd ;
    private Button btnCreateUser;
    DBHelper myDB;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm_pwd = findViewById(R.id.confirm_pwd);
        btnCreateUser = findViewById(R.id.btn_create_user);

        myDB = new DBHelper( this);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString();
                String repass = confirm_pwd.getText().toString();
                String user = username.getText().toString();

            /*    if(strPassword!=null && strConfirmPassword!=null && strPassword.equalsIgnoreCase(strConfirmPassword)){
                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString( "Password", strPassword);
                    editor.putString( "Username", strUsername);
                    editor.commit();

                    SignupActivity.this.finish();
                }*/
                if (user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(SignupActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }


                else{
                    if(pass.equals(repass)) {
                    //   DBHelper myDB = null;
                        Boolean usercheckResult = myDB.checkusername(user);
                        if (usercheckResult == false) {
                            Boolean regResult = myDB.insertData(user, pass);
                            if (regResult == true) {
                                Toast.makeText(SignupActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignupActivity.this, "Register Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignupActivity.this, "User already Exists.\n Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                        else
                        {
                            Toast.makeText(SignupActivity.this, "Password not matching",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

}}
