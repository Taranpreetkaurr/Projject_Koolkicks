package com.example.projject;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class payment_info extends AppCompatActivity {
    EditText txt_card_number,txt_expiration_date,txt_security,txt_street_address,txt_street_name,txt_pin,txt_state,txt_phone;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);
        txt_card_number=findViewById(R.id.card_number);
        txt_expiration_date=findViewById(R.id.expiry);
        txt_security=findViewById(R.id.security_code);
        checkBox=findViewById(R.id.checkbox);

        txt_street_address=findViewById(R.id.street_address);
        txt_street_name=findViewById(R.id.street_name);
       // txt_pin=findViewById(R.id.pincode);
      //  txt_state=findViewById(R.id.state);
        //txt_phone=findViewById(R.id.phone_num);

    }
}