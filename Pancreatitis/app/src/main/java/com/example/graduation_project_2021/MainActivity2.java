package com.example.graduation_project_2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.graduation_project_2021.databinding.ActivityMain2Binding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
    }

    public void btn_create(View view){
        String email = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        String confirm = binding.edtConfirmPassword.getText().toString();
        if(email.equals("") || password.equals("") || !password.equals(confirm)){
            Toast.makeText(this, "Enter e-mail and password", Toast.LENGTH_LONG).show();
        } else {
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(@NonNull AuthResult authResult) {
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity2.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }
    public void btn_back(View view){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}