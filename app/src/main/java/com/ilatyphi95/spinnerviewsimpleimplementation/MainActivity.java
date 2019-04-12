package com.ilatyphi95.spinnerviewsimpleimplementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int mCurrenPostion;
    private TextView mTvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spSelect = findViewById(R.id.sp_select);
        mTvDisplay = findViewById(R.id.tv_display);
        Button btShowSelected = findViewById(R.id.bt_show_selected);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_items, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spSelect.setAdapter(adapter);
        spSelect.setOnItemSelectedListener(this);

        btShowSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] items = getResources().getStringArray(R.array.sp_items);
                mTvDisplay.setText(items[mCurrenPostion]);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final int viewId = parent.getId();
        if( viewId == R.id.sp_select ) {
            mCurrenPostion = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
