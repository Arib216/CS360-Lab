package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        View addCityLayout = findViewById(R.id.add_city_layout);
        EditText addCityEditText = findViewById(R.id.add_city_editText);
        Button addCityButton = findViewById(R.id.add_city_button);
        Button deleteCityButton = findViewById(R.id.delete_city_button);
        Button confirmButton = findViewById(R.id.confirm_button);

        dataList = new ArrayList<>(Arrays.asList("Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"));
        cityAdapter = new ArrayAdapter<>(this, R.layout.context, dataList);
        cityList.setAdapter(cityAdapter);

        addCityButton.setOnClickListener(v -> addCityLayout.setVisibility(View.VISIBLE));

        confirmButton.setOnClickListener(v -> {
            String city = addCityEditText.getText().toString();
            if (!city.isEmpty()) {
                dataList.add(city);
                cityAdapter.notifyDataSetChanged();
                addCityEditText.setText("");
                addCityLayout.setVisibility(View.GONE);
            }
        });

        cityList.setOnItemClickListener((p, v, pos, id) -> selectedPosition = pos);

        deleteCityButton.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                dataList.remove(selectedPosition);
                cityAdapter.notifyDataSetChanged();
                selectedPosition = -1;
            }
        });
    }
}