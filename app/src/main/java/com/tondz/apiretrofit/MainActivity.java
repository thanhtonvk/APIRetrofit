package com.tondz.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    List<Student> studentList;
    StudentAdapter adapter;
    Student student;
    OpenWheather openWheather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        loadData();
//        onClick();
        APIService.apiService.GetAllTaiKhoan().enqueue(new Callback<ArrayList<TaiKhoan>>() {
            @Override
            public void onResponse(Call<ArrayList<TaiKhoan>> call, Response<ArrayList<TaiKhoan>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        ArrayAdapter<TaiKhoan> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,response.body());
                        lv_student.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TaiKhoan>> call, Throwable t) {

            }
        });
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk  = edt_name.getText().toString();
                APIService.apiService.GetThongTinTaiKhoan(tk).enqueue(new Callback<ThongTinTaiKhoan>() {
                    @Override
                    public void onResponse(Call<ThongTinTaiKhoan> call, Response<ThongTinTaiKhoan> response) {
                        if(response.isSuccessful()){
                            if(response.body()!=null){
                                edt_address.setText(response.body().toString());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ThongTinTaiKhoan> call, Throwable t) {

                    }
                });
            }
        });
    }

    private void onClick() {
        lv_student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                student = studentList.get(i);
                edt_name.setText(student.getName());
                edt_address.setText(student.getAddress());
                edt_classroom.setText(student.getClassRoom() + "");
                edt_dateofbirth.setText(student.getDateOfBirth());
                edt_avatar.setText(student.getAvatar());
            }
        });
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student std = new Student(edt_name.getText().toString(), edt_dateofbirth.getText().toString(), Integer.parseInt(edt_classroom.getText().toString()), edt_address.getText().toString(), edt_avatar.getText().toString());
                APIService.apiService.addStudent(std).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.body() != null) {
                            if (response.body() > 0) {
                                Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Không thành công", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Lỗi kết nối, không thành công", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student std = new Student(edt_name.getText().toString(), edt_dateofbirth.getText().toString(), Integer.parseInt(edt_classroom.getText().toString()), edt_address.getText().toString(), edt_avatar.getText().toString());
                std.setID(student.getID());
                APIService.apiService.updateStudetn(std).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.body() != null) {
                            if (response.body() > 0) {
                                Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Không thành công", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Lỗi kết nối, không thành công", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APIService.apiService.deleteStudent(student.getID()).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.body() != null) {
                            if (response.body() > 0) {
                                Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Không thành công", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Lỗi kết nối, không thành công", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    List<Student> tmp = new ArrayList<>();

    private void loadData() {
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(MainActivity.this, studentList);
        lv_student.setAdapter(adapter);
        APIService.apiService.getStudentList().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.body() != null) {
                    for (Student student : response.body()) {
                        studentList.add(student);

                    }

                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Deo co dl", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                tmp = new ArrayList<>();
                APIService.apiService.getStudentList().enqueue(new Callback<List<Student>>() {
                    @Override
                    public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                        for(Student student:response.body()){
                            tmp.add(student);
                        }
                        if(tmp.size()!=studentList.size()){
                            studentList = tmp;
                            adapter = new StudentAdapter(MainActivity.this, studentList);
                            lv_student.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Student>> call, Throwable t) {

                    }
                });
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);


    }

    private void initView() {
        lv_student = findViewById(R.id.lv_student);
        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_dateofbirth = findViewById(R.id.edt_dateofbirth);
        edt_classroom = findViewById(R.id.edt_classroom);
        edt_avatar = findViewById(R.id.edt_avatar);
    }
}