package sg.edu.rp.c346.id20033454.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        btnDisplayDate=findViewById(R.id.buttonDisplayDate);
        btnDisplayTime=findViewById(R.id.buttonDisplayTime);
        tvDisplay=findViewById(R.id.textView);
        btnReset=findViewById(R.id.reset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hour = "";
                if (tp.getCurrentHour() <10){
                    hour = "0" + tp.getCurrentHour();
                } else {
                    hour += tp.getCurrentHour();
                }
                String minute = "";
                if (tp.getCurrentMinute() <10){
                    minute = "0" + tp.getCurrentMinute();
                } else {
                    minute += tp.getCurrentMinute();
                }
                String output="The time is " + hour + ":" + minute;
                tvDisplay.setText(output);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String day = "";
                if (dp.getDayOfMonth() <10){
                    day = "0" + dp.getDayOfMonth();
                } else {
                    day += dp.getDayOfMonth();
                }
                int monthtest = dp.getMonth()+1;
                String month = "";
                if (monthtest <10){
                    month = "0" + monthtest;
                } else {
                    month += monthtest;
                }
                int year = dp.getYear();

                String output = String.format("Date is %s/%s/%d", day, month, year);
                tvDisplay.setText(output);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020,0,1);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
            }
        });
    }
}