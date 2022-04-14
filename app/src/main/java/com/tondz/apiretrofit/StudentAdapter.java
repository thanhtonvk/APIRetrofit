package com.tondz.apiretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    List<Student> studentList;

    public StudentAdapter(@NonNull Context context, List<Student> studentList) {

        super(context, 0, studentList);
        this.studentList = studentList;
    }

    @Override
    public int getCount() {

        return studentList.size();

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, null, false);
        }
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_address = convertView.findViewById(R.id.tv_address);
        TextView tv_classroom = convertView.findViewById(R.id.tv_classroom);
        TextView tv_dateofbirth = convertView.findViewById(R.id.tv_dateofbirth);
        ImageView img_avatar = convertView.findViewById(R.id.img_view);
        Student student = studentList.get(position);
        tv_name.setText(student.getName());
        tv_address.setText(student.getAddress());
        tv_classroom.setText(student.getGender() + "");
        tv_dateofbirth.setText(student.getDateOfBirth());
        return convertView;
    }

}
