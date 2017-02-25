package com.example.xxmlg.trabajo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.usernameEditText);
        password=(EditText)findViewById(R.id.passwordEditText);

        Button login = (Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passValidation()){

                }
            }
        });
    }

    private boolean checkCredentials(){
        boolean rightCredentials = true;
        username.setError(null);
        password.setError(null);
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        if(usernameText.equalsIgnoreCase("cesars")){
            if(passwordText.equalsIgnoreCase("hola123")){//Las credenciales son correctas
                Toast.makeText(getApplicationContext(),"Credenciales Correctas!!", Toast.LENGTH_LONG).show();
            }
            else{//La contraseña es incorrecta
                password.setError("Contraseña incorrecta");
                rightCredentials=false;
            }
        }
        else{
            username.setError("Usuario incorrecto");
            rightCredentials = false;
        }
        return rightCredentials;
    }

    private boolean passValidation(){
        boolean passValidation = true;
        username.setError(null);
        String usernameText = username.getText().toString();
        if(usernameText.length() == 0){ //En caso de que el campo este vacío
         username.setError("User no puede estar vacio");
         passValidation=false;
        }
        String passwordText = password.getText().toString();
        if(passwordText.length() == 0){ //Cuando el pass esta vacio
            password.setError("Password no debe estar vacio");
            passValidation=false;
        }
        return passValidation;
    }
}
