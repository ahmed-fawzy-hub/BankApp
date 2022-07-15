package com.hanynemr.yat730bankapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etAmount, etLimit, etPercent;
    TextView tvResult;

    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount = findViewById(R.id.etAmount);
        etLimit = findViewById(R.id.etLimit);
        etPercent = findViewById(R.id.etPercent);
        tvResult = findViewById(R.id.tvResult);

    }

    public void calc(View view) {
        int amount = Integer.parseInt(etAmount.getText().toString());
        int limit = Integer.parseInt(etLimit.getText().toString());
        int percent = Integer.parseInt(etPercent.getText().toString());
        byte year = 0;
        while (amount < limit) {
            year++;
            amount = amount + amount * percent / 100;

        }

        StringBuilder temp = new StringBuilder();
        temp.append("\n amount =")
                .append(etAmount.getText().toString())
                .append(" - limit=")
                .append(limit)
                .append("- percent=")
                .append(percent)
                .append(" - year =")
                .append(year);
//        String line = "\n amount =" + etAmount.getText().toString() + " - limit=" + limit + " - percent=" + percent + " - year =" + year;
        String line = temp.toString();
        if (tvResult.getText().toString().contains(line)) {
            Toast.makeText(this, "line exists", Toast.LENGTH_SHORT).show();
            builder.append(tvResult.getText().toString());
            int index = builder.indexOf(line);// hello ahmed
            builder.delete(index, index + line.length());
            builder.insert(0, line);
            tvResult.setText(builder);
//            String old = tvResult.getText().toString().replace(line, "");
//            tvResult.setText(line+old);

        } else {
            tvResult.append(line);
        }

    }
}