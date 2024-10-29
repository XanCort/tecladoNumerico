package com.example.entregablelayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private class ReceptorBotton implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Has pulsado el botón " + ((Button) view).getText() + "", Toast.LENGTH_LONG).show();

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        for (int i = 1; i <= 17; i++) {
            int idAsignar = getResources().getIdentifier("boton" + i, "id", getPackageName());
            Button boton = findViewById(idAsignar);
            boton.setOnClickListener(new ReceptorBotton());
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}

