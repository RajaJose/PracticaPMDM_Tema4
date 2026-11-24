package es.studium.practicatema4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements OnInterface, View.OnClickListener {

    DialogoNombre dialogoNombre;
    Button btnComenzar;
    String nombre, sexo, especie, profesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnComenzar = findViewById(R.id.btnComenzar);
        btnComenzar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dialogoNombre = new DialogoNombre();
        dialogoNombre.setCancelable(false);
        dialogoNombre.show(getSupportFragmentManager(), "dialogo_nombre");
    }

    @Override
    public void onNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void onSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public void onEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public void onProfesion(String profesion) {
        this.profesion = profesion;

        Fragmento fragmentoFinal = Fragmento.newInstance(nombre, sexo, especie, this.profesion);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.main, fragmentoFinal)
                .addToBackStack(null)
                .commit();

        btnComenzar.setVisibility(View.GONE);
    }
    @Override
    public void onFragmentoVolver() {
        btnComenzar.setVisibility(View.VISIBLE);
    }
}
