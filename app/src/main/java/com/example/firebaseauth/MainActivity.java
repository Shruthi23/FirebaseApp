package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
   // FirebaseAuth mauth;
    FirebaseAuth mAuth;
    //TextInputEditText email;
    EditText email;
    EditText password;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editText1);
        password=findViewById(R.id.editText2);
        btnRegister=findViewById(R.id.button1);
        mAuth=FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(view ->{
            createUser();

        });
    }
    public void createUser(){
        String userEmail=email.getText().toString().trim();
        Log.e("email",userEmail.toString());
        String userPass=password.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword("shruthi97@gmail.com","Qwerty@123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                   Log.d("Success","success");
                    Toast.makeText(MainActivity.this, "Succesfull", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.e("Fail", String.valueOf(task.getException()));
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}