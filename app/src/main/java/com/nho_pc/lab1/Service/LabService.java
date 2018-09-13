package com.nho_pc.lab1.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class LabService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "StartService", Toast.LENGTH_SHORT).show();
        Bundle bundle=intent.getBundleExtra("Student");
        int StuID=bundle.getInt("StuID");
        String StuName=bundle.getString("StuName");
        String Class=bundle.getString("Class");
        String content="Thêm sinh viên thành công.\n Thông tin sinh viên :\n Sinh viên:\t"+StuID+" - "+StuName+"\n Lớp:\t"+Class;
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
