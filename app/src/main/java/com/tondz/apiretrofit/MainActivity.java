package com.tondz.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView lv_student;
    EditText edt_name, edt_address, edt_dateofbirth, edt_classroom, edt_avatar;
    List<Student> studentList = new ArrayList<>();
    StudentAdapter adapter;
    Student student;
    OpenWheather openWheather;
    AutoCompleteTextView edt_search;
    ArrayAdapter arrayAdapter;
    List<String>studentSearch = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
        onClick();

        loadData();

    }

    private void onClick() {

        lv_student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                student = studentList.get(i);
                edt_name.setText(student.getName());
                edt_address.setText(student.getAddress());
                edt_classroom.setText(student.getGender());
                edt_dateofbirth.setText(student.getDateOfBirth());
            }
        });
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student std = new Student(edt_name.getText().toString(), edt_dateofbirth.getText().toString(), edt_classroom.getText().toString(), edt_address.getText().toString());
                APIService.apiService.addStudent(std).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("TAG","Click");
                        if (response.body() != null) {
                            Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        loadData();
                    }
                });
            }
        });
        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student std = new Student(edt_name.getText().toString(), edt_dateofbirth.getText().toString(), edt_classroom.getText().toString(), edt_address.getText().toString());
                std.setID(student.getID());
                APIService.apiService.updateStudent(std.getID(),std).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body() != null) {
                            Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        loadData();
                    }
                });
            }
        });
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentList.remove(student);
                adapter = new StudentAdapter(getApplicationContext(), studentList);
                lv_student.setAdapter(adapter);
                APIService.apiService.deleteStudent(student.getID()).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body() != null) {
                            Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
            }
        });
    }


    private void loadData() {
        studentList = new ArrayList<>();
        APIService.apiService.getStudentList().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.body() != null) {
                    for (Student student : response.body()) {
                        studentSearch.add(student.getName());
                        studentList.add(student);
                        adapter = new StudentAdapter(getApplicationContext(), studentList);
                        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,studentSearch);
                        lv_student.setAdapter(adapter);
                        edt_search.setAdapter(arrayAdapter);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Deo co dl", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }

    private void initView() {
        lv_student = findViewById(R.id.lv_student);
        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_dateofbirth = findViewById(R.id.edt_dateofbirth);
        edt_classroom = findViewById(R.id.edt_classroom);
        edt_avatar = findViewById(R.id.edt_avatar);
        edt_search= findViewById(R.id.edt_search);
    }
}