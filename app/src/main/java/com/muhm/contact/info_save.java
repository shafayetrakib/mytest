package com.muhm.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class info_save extends AppCompatActivity {
    EditText serial,name,roll,fatherName,address;
    Button save,click;
    FirebaseDatabase db;
    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_save);

        serial=findViewById(R.id.serial);
        name=findViewById(R.id.name);
        roll=findViewById(R.id.roll);
        fatherName=findViewById(R.id.father_name);
        address=findViewById(R.id.adress);
        save=findViewById(R.id.btn_save);


        db=FirebaseDatabase.getInstance();
        dr=db.getReference("StudentInformation");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });



    }

    private void saveData() {
        String Serial=serial.getText().toString().trim();
        String Name=name.getText().toString().trim();
        String Roll=roll.getText().toString().trim();
        String FatherName=fatherName.getText().toString().trim();
        String Address=address.getText().toString().trim();

        if(Serial.isEmpty() ){
            serial.setError("Please Enter student serial ");
            serial.requestFocus();
            return;
        }
        if(Name.isEmpty()){
            name.setError("Please Enter student serial ");
            name.requestFocus();
            return;
        }
        if(Roll.isEmpty()){
            roll.setError("Please Enter student Roll Number ");
            roll.requestFocus();
            return;
        }
        if(FatherName.isEmpty()){
            fatherName.setError("Please Enter student FatherName ");
            fatherName.requestFocus();
            return;
        }
        if(Address.isEmpty()){
            address.setError("Please Enter student Address ");
            address.requestFocus();

        }else {
            if(!Serial.isEmpty() && !Name.isEmpty() && !Roll.isEmpty() && !FatherName.isEmpty() && !Address.isEmpty()){
                DatabaseReference currentChild = dr.push();
                StudentInfoModel sim = new StudentInfoModel(currentChild.getKey(), Serial, Name, Roll, FatherName, Address);
                currentChild.setValue(sim);
                Toast.makeText(this, "data Successfully set", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(info_save.this, details.class));
            }
        }
    }

}