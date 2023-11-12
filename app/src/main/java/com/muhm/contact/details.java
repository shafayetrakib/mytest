package com.muhm.contact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class details extends AppCompatActivity {
    ListView details;
    // List<StudentInfoModel> allstudent=new ArrayList<>();
    List<StudentInfoModel> studentlist;
    Adapter adapter;
    SearchView searchView;
    FirebaseDatabase db;
    DatabaseReference dr;

    ImageView btnDelete,btnEdit,btnPayment;
    Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        info=findViewById(R.id.btn_info);

        details=findViewById(R.id.details);
        //searchView=findViewById(R.id.for_search);

        db= FirebaseDatabase.getInstance();
        dr=db.getReference("StudentInformation");


        studentlist = new ArrayList<>();
        adapter = new Adapter(details.this,studentlist);



        //Data find out for set in listview
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentlist.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    StudentInfoModel studentInfoModel=dataSnapshot.getValue(StudentInfoModel.class);
                    //allstudent.add(studentInfoModel);
                    studentlist.add(studentInfoModel);

                }
                details.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(details.this,info_save.class));
            }
        });

        details.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                studentBottomDialog();




                return false;
            }
        });


    }



    private void studentBottomDialog(){
        BottomSheetDialog stDialog=new BottomSheetDialog(this);
        stDialog.setContentView(R.layout.bottom_sheet);

        btnDelete =stDialog.findViewById(R.id.btn_delete);
        btnEdit=stDialog.findViewById(R.id.btn_edit);
        btnPayment=stDialog.findViewById(R.id.btn_pymaent);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //StudentInfoModel mm=studentlist.get(postion);
                // String key=mm.getId();
                //dr.child(key).removeValue();
                Toast.makeText(details.this, "item delete", Toast.LENGTH_SHORT).show();
            }
        });

        stDialog.show();
    }



}