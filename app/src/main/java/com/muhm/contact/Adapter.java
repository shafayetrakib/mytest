package com.muhm.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.muhm.contact.R;
import com.muhm.contact.StudentInfoModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<StudentInfoModel> {

    Activity context;
    List<StudentInfoModel> studentlist;


    public Adapter(Activity context,  List<StudentInfoModel> studentlist) {
        super(context, R.layout.item_layout, studentlist);
        this.context = context;
        this.studentlist = studentlist;

    }

    @NonNull
    @Override
    public View getView(int position,  View view,  ViewGroup parent) {
        if(view == null){
            view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        }

        TextView Name=view.findViewById(R.id.name);
        TextView Serial=view.findViewById(R.id.serial);
        TextView Roll=view.findViewById(R.id.roll);
        TextView FatherName=view.findViewById(R.id.txt_fathername);
        TextView Address=view.findViewById(R.id.address);

        StudentInfoModel studentInfoModel=studentlist.get(position);



        Name.setText(studentInfoModel.getName());
        Serial.setText(studentInfoModel.getSerialNumber());
        Roll.setText(studentInfoModel.getRoll());
        FatherName.setText(studentInfoModel.getFatherName());
        Address.setText(studentInfoModel.getAddress());



        return view;
    }
}
