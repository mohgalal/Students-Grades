package com.example.studentsgrade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText totalEt, subjEt;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalEt = findViewById(R.id.total_et);
        subjEt = findViewById(R.id.sub_et);
        calcBtn = findViewById(R.id.calc_btn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalEt.getText().toString().equals("")||subjEt.getText().toString().equals("")){
                    totalEt.setError("Please Enter The Total");
                    subjEt.setError("Please Enter NO of Subjects");}
                else {
                    double total, precentage;
                    int subj;
                    String grade, sign;

                    total = Double.parseDouble(totalEt.getText().toString());
                    subj = Integer.parseInt(subjEt.getText().toString());

                    precentage = total / subj;

                    if (precentage >= 85)
                        grade = "Exellent";
                    else if (precentage > 85)
                        grade = "Very Good";
                    else if (precentage > 75)
                        grade = "Good";
                    else if (precentage > 65)
                        grade = "Pass";
                    else
                        grade = "Fail";

                    switch (grade) {

                        case "Exellent":
                            sign = "A";
                            break;
                        case "Very Good":
                            sign = "B";
                            break;
                        case "Good":
                            sign = "C";
                            break;
                        case "Pass":
                            sign = "D";
                            break;
                        default:
                            sign = "F";
                    }
                    DecimalFormat d = new DecimalFormat("00.00");

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Zagazeg Universty");
                    alert.setIcon(R.drawable.graduationgap);
                    alert.setMessage("The Precentage is : "+d.format(precentage)
                            + "\n" + "The Grade is : " + grade
                            + "\n" + "The Sign is : " + sign);
                    alert.setPositiveButton("Thanks", null);
                    alert.create();
                    alert.show();

                }

            }
        });

    }
}