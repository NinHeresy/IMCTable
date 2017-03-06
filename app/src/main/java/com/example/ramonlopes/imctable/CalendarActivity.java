package com.example.ramonlopes.imctable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.darwindeveloper.onecalendar.clases.Day;
import com.darwindeveloper.onecalendar.views.OneCalendarView;

public class CalendarActivity extends AppCompatActivity {

    public OneCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (OneCalendarView) findViewById(R.id.newCalendar);
        calendarView.setOnCalendarChangeListener(new OneCalendarView.OnCalendarChangeListener() {
            @Override
            public void prevMonth() {

            }

            @Override
            public void nextMonth() {

            }
        });


        calendarView.setOneCalendarClickListener(new OneCalendarView.OneCalendarClickListener() {
            @Override
            public void dateOnClick(Day day, int i) {

            }

            @Override
            public void dateOnLongClick(Day day, int i) {

            }
        });


    }
}
