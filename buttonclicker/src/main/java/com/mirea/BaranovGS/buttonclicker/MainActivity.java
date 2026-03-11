package com.mirea.BaranovGS.buttonclicker;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvOut;
    private Button btnWhoAmI;
    private Button btnItIsNotMe;

    private CheckBox checkBoxTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvOut = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        checkBoxTask = findViewById(R.id.checkBoxTask);

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean currentState = checkBoxTask.isChecked();
                checkBoxTask.setChecked(!currentState);
                tvOut.setText("Мой номер по списку № 3");
            }
        };
        btnWhoAmI.setOnClickListener(oclBtn);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onMyButtonClick(View view) {
        tvOut.setText("Это не я сделал");

        boolean currentState = checkBoxTask.isChecked();
        checkBoxTask.setChecked(!currentState);

        Toast.makeText(this, "Месендж", Toast.LENGTH_SHORT).show();
    }
}