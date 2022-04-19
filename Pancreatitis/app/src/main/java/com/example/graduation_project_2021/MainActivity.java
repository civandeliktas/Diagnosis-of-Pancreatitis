package com.example.graduation_project_2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.graduation_project_2021.databinding.ActivityMain2Binding;
import com.example.graduation_project_2021.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();

    }

    public void btn_register (View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
    public void login(View view){
        String email = binding.editTextTextPersonName.getText().toString();
        String password = binding.editTextTextPassword.getText().toString();

        if(email.equals("") || password.equals("")){
            Toast.makeText(this, "Enter email and password", Toast.LENGTH_LONG).show();
        } else {
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(@NonNull AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}