package com.example.terceraedad;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FifthFragment extends Fragment {
    View view;
    private RecyclerView recyclerViewEvents;
    private List<Event> eventList;
    private EventAdapter eventAdapter;
    private EditText editText;
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fifth, container, false);
        CalendarView calendarView = view.findViewById(R.id.calendarView2);
        recyclerViewEvents = view.findViewById(R.id.recyclerView2);
        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList);
        editText = view.findViewById(R.id.editTextText);
        button = view.findViewById(R.id.button8);

        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewEvents.setAdapter(eventAdapter);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        Event event = new Event(editText.getText().toString(), selectedDate);
                        eventList.add(event);
                        eventAdapter.notifyDataSetChanged();
                    }
                });

            }
        });

        return view;
    }
}