package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private ImageView imgDemo;
    private float rotationAngle = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);
        imgDemo = findViewById(R.id.imgDemo);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        // Registrar menú contextual
        registerForContextMenu(imgDemo);
    }

    // ------------ MENÚ SUPERIOR (Toolbar) ------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_cambiar_texto) {
            txtResultado.setText("Texto cambiado desde el menú");
            Toast.makeText(this, "Texto actualizado", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.menu_cambiar_imagen) {
            imgDemo.setImageResource(R.drawable.imagen2);
            Toast.makeText(this, "Imagen cambiada", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // ------------ MENÚ CONTEXTUAL ------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Opciones de imagen");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_rotar) {
            rotationAngle += 45f;
            imgDemo.setRotation(rotationAngle);
            Toast.makeText(this, "Imagen rotada", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.menu_eliminar) {
            imgDemo.setImageDrawable(null);
            Toast.makeText(this, "Imagen eliminada", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}
