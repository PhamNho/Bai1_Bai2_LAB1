package com.nho_pc.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nho_pc.lab1.Service.LabService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStartService, btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("(Bài 1 + Bài 2) LAB 1");
        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // khởi tạo đối tượng Intent
        Intent intent = new Intent(MainActivity.this, LabService.class);
        // khởi tạo đối tượng Bundle
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.btnStartService:
                // khai báo các giá trị và gán vào Bundle
                bundle.putInt("StuID", 1);
                bundle.putString("StuName", "Nhớ");
                bundle.putString("Class", "PT13355");
                // gắn Bundle vào Intent
                intent.putExtra("Student", bundle);
                startService(intent);
                break;
            case R.id.btnStopService:
                Toast.makeText(this, "StopService", Toast.LENGTH_SHORT).show();
                stopService(intent);
                break;
        }
    }
}
