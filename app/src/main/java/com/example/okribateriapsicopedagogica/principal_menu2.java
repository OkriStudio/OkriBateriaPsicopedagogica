package com.example.okribateriapsicopedagogica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;

public class principal_menu2 extends AppCompatActivity {

    private boolean isOptionsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal_menu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        LinearLayout optionsLayout = findViewById(R.id.optionsLayout);

        loadFragment(new foro());

        fab.setOnClickListener(v -> {
            if (isOptionsVisible) {
                optionsLayout.setVisibility(View.GONE);
            } else {
                optionsLayout.setVisibility(View.VISIBLE);
            }
            isOptionsVisible = !isOptionsVisible;
        });

        findViewById(R.id.option1).setOnClickListener(v -> loadFragment(new foro()));
        findViewById(R.id.option2).setOnClickListener(v -> loadFragment(new registrar_alumno()));
        findViewById(R.id.option3).setOnClickListener(v -> loadFragment(new revision_alumnos()));
        findViewById(R.id.option5).setOnClickListener(v -> {
            Intent intent = new Intent(principal_menu2.this, MensajesChat.class);
            startActivity(intent);
        });
        findViewById(R.id.option4).setOnClickListener(v -> {
            Intent intent = new Intent(principal_menu2.this, Baterias.class);
            startActivity(intent);
        });
        findViewById(R.id.option6).setOnClickListener(v -> loadFragment(new notifiacion()));
    }


    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contendor, fragment)
                .addToBackStack(null)
                .commit();
    }
}
