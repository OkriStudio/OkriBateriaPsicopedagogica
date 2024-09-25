package com.example.okribateriapsicopedagogica;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ForoAlumnos extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3;
    private TextView tituloNoticia1, tituloNoticia2, tituloNoticia3;
    private TextView descripcionNoticia1, descripcionNoticia2, descripcionNoticia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro_alumnos);

        // Referencias a las vistas
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        tituloNoticia1 = findViewById(R.id.tituloNoticia1);
        tituloNoticia2 = findViewById(R.id.tituloNoticia2);
        tituloNoticia3 = findViewById(R.id.tituloNoticia3);

        descripcionNoticia1 = findViewById(R.id.descripcionNoticia1);
        descripcionNoticia2 = findViewById(R.id.descripcionNoticia2);
        descripcionNoticia3 = findViewById(R.id.descripcionNoticia3);

        // Cargar las noticias
        cargarNoticias();
    }

    private void cargarNoticias() {
        // Cargar imágenes (podrían provenir de una URL en una implementación real)
        imageView1.setImageResource(R.drawable.noticia1);
        imageView2.setImageResource(R.drawable.noticia2);
        imageView3.setImageResource(R.drawable.noticia3);

        // Asignar los textos de las noticias
        tituloNoticia1.setText("Día del Deporte en la Escuela");
        descripcionNoticia1.setText("Se celebró el día del deporte con diversas actividades en la escuela.");

        tituloNoticia2.setText("Nueva Biblioteca Escolar");
        descripcionNoticia2.setText("Inauguramos la nueva biblioteca con más de 500 libros para los alumnos.");

        tituloNoticia3.setText("Visita de Científicos");
        descripcionNoticia3.setText("Un grupo de científicos visitó la escuela para hablar sobre la ciencia en el día a día.");
    }
}
