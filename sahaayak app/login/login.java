package com.technic.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button btnLogin ;
    private Button btnSignUP ;

    DBHelper myDB;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.button5);
        btnSignUP = findViewById(R.id.button6);

        myDB = new DBHelper( this);
       // final Context context =this;

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this , SignupActivity.class);
                startActivity(i);
                Toast.makeText( LoginActivity.this," you Clicked on signup", Toast.LENGTH_SHORT).show();


            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String user = username.getText().toString();
                String pass = password.getText().toString();
            //    String strUsername = "Nisarg";
              //  String strPassword = "P1234";
            //    Toast.makeText( LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
               // startActivity(intent);

               // String username_from_ed = edUsername.getText().toString();
                //String password_from_ed = edPassword.getText().toString();

                if (user.isEmpty() || pass.isEmpty() )
                {
                    Toast.makeText( LoginActivity.this,"Username and password cannot be blank", Toast.LENGTH_SHORT).show();

             //   return;
                }
                else
                {
                    Boolean result = myDB.checkusernamePassword(user,pass);
                    if(result==true){
 // "YAHA PE NEXT PAGE KA NAME.CLASS DAALNA HAI"
                  //      Intent intent = new Intent (getApplicationContext(), welcome.class);
                   //     startActivity(intent);
                        Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
               /* if(password_from_ed.isEmpty()){
                    Toast.makeText( LoginActivity.this,"Password cannot be blank", Toast.LENGTH_SHORT).show();
                return;
                }*/
             /*   if(strUsername !=null && username_from_ed !=null && strUsername.equalsIgnoreCase(username_from_ed)){
                    if(strPassword!= null && password_from_ed !=null && strPassword.equalsIgnoreCase(password_from_ed)) {
                        Toast.makeText( LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(  LoginActivity.this,  "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(  LoginActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();


                    }*/


                }});
    };
}


