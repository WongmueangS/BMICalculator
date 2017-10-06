package com.example.bmicalculator;

import android.content.Intent;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        TextView output = (TextView)findViewById(R.id.Output);

        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("bmi_value",0); //(keyต้องตรงกัน,ค่าดีฟอล)
        String bmiText = intent.getStringExtra("bmi_text");
        //การบ้านแสดงผลลัพ์  ค่าที่ได้คือ 20.00
        //น้ำหนักอยู่ในเกณฑ์ปกติ
        String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s" , bmi,bmiText );
        output.setText(result);


    }


}
