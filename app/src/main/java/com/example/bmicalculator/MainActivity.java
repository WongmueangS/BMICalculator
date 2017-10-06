package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /* implements View.OnClickListener*/{
   //ประกาศตัวแปรview
    private EditText mHeightEditText;
    private EditText mWeightEditText;
    private Button mCalculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);//กดfb(findViewById)
        mCalculateButton = (Button) findViewById(R.id.calculate_button);



        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String heightText =  mHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);

                Double weight = Double.valueOf(mWeightEditText.getText().toString());

                Double bmi = weight / ((height/100) * (height/100));

                String bmiText = getBmiText(bmi);


//                String result = "ค่า BMI ที่ได้คือ "+ String.valueOf(bmi);
//                result += "\n\n อยู่ในเกณฑ์ : " + bmiText;
                  String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s" , bmi,bmiText );




//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("BMI Result");
//                dialog.setMessage(result);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {  //  dialog.setPositiveButton("OK", new);
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //โค้ดที่ต้องการให้ทำเมือ ปุ่ม OK ในไดอะล็อกถูกคลิ๊ก
//                       // finish();// ปิดเอคทิวิตีปัจจุบัน
//                        mHeightEditText.setText("");
//                        mWeightEditText.setText("");
//                        mHeightEditText.requestFocus(); //เริ่มกรอกใหม่ช่องส่วนสูง
//
//                    }
//                });
//                dialog.show();
                Intent intent = new Intent(MainActivity.this, BmiResultActivity.class); // .class เสมอ
                intent.putExtra("bmi_value",bmi); //่ส่งค่าไป (key,value)
                intent.putExtra("bmi_text",bmiText);

                startActivity(intent); //fire intent


//               Toast t = Toast.makeText(
//                        MainActivity.this,"ค่า ฺBMI ที่ได้คือ " + String.valueOf(bmi),
//                        Toast.LENGTH_SHORT
//
//                );
//                t.show();
            }
        });
        //สร้าง Object ที่ทำหน้าที่เ็น Listener ของปุ่ม
//        MyListener listener = new MyListener();
//        // กำหนดออบเจ็คที่เป็น Listener ให้กับปุ่ม
//        mCalculateButton.setOnClickListener(listener);
    }//ปิดเทธอด onCreate

    private String getBmiText(Double bmi) {
        String bmiText = "";
        if(bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }else if (bmi < 25){
            bmiText = "น้ำหนักปกติ";
        }else if (bmi < 30){
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }else {
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return bmiText;
    }

//    private class MyListener implements View.OnClickListener{
//
//
//        @Override
//        public void onClick(View v) { //ทำงานเมื่อปุ่มถูกคลิก
//            //
//            Toast t  = Toast.makeText(
//                    MainActivity.this, //context
//                    "Hello",            // ข้อความที่ต้องการแสดงใน Toast
//                    Toast.LENGTH_SHORT); //ระยะเวลาในการแสดง Toast
//            t.show();
//        }
//
//    }


}
