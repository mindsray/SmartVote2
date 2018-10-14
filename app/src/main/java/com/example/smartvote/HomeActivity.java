package com.example.smartvote;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button checkButton = findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText IDcardEditText = findViewById(R.id.ID_card_text);
                String IDcard = IDcardEditText.getText().toString();
                if (IDcard.length() != 13) {
                    Toast t = Toast.makeText(HomeActivity.this, "กรุณากรอกหมายเลขบัตรประชาชน13หลัก", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    String print = "";
                    boolean check = checkIDCard(IDcard);
                    if (check == true)
                        print = "คุณมีสิทธิ์เลือกตั้ง";
                    else
                        print = "คุณไม่มีสิทธิ์เลือกตั้ง";

                    AlertDialog.Builder dialog = new AlertDialog.Builder(HomeActivity.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setMessage(print);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setCancelable(true);
                    dialog.show();
                }

            }
        });
    }

    private boolean checkIDCard(String id) {
        char c = id.charAt(0);
        int lenght = id.length();
        int count = 0;
        for (int i = 0; i < lenght; i++) {
            if (id.charAt(i) == c) {
                count++;
            }
        }
        if (count == lenght)
            return true;
        else
            return false;
    }
}
