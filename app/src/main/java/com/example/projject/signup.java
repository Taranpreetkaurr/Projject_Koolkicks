package com.example.projject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

public class signup extends AppCompatActivity {
    EditText txt_email,txt_pass,txt_confirm_pass;
    Button btn_signup;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();
        txt_email=findViewById(R.id.email);
        txt_pass=findViewById(R.id.pass);
        txt_confirm_pass=findViewById(R.id.cpass);
        btn_signup=findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txt_email.getText().toString();
                String pass = txt_pass.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Please enter your E-mail address",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
                }
                if (pass.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
                }
                if (pass.length()<8){
                    Toast.makeText(getApplicationContext(),"Password must be more than 8 digit",Toast.LENGTH_LONG).show();
                }
                else{
                    auth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(signup.this, task.getException().toString(),Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        startActivity(new Intent(signup.this, MainActivity.class));
                                        finish();
                                        Toast.makeText(signup.this, "Successfully Singup !",Toast.LENGTH_LONG).show();

                                    }
                                }
                            });}
            }


        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public  void refresh(){
        txt_email.setText("");
        txt_pass.setText("");
        txt_confirm_pass.setText("");


    }
}