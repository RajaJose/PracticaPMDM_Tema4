package es.studium.practicatema4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Random;

public class Fragmento extends Fragment implements View.OnClickListener {

    OnInterface onInterface;
    ImageView imagen;

    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_SEXO = "sexo";
    private static final String ARG_ESPECIE = "especie";
    private static final String ARG_PROFESION = "profesion";

    private String nombre_, sexo_, especie_, profesion_;

    public Fragmento() {
        // Required empty public constructor
    }

    public static Fragmento newInstance(String nombre, String sexo, String especie, String profesion) {
        Fragmento fragment = new Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_SEXO, sexo);
        args.putString(ARG_ESPECIE, especie);
        args.putString(ARG_PROFESION, profesion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre_ = getArguments().getString(ARG_NOMBRE);
            sexo_ = getArguments().getString(ARG_SEXO);
            especie_ = getArguments().getString(ARG_ESPECIE);
            profesion_ = getArguments().getString(ARG_PROFESION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento, container, false);
        Button btnVolver = view.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagen = view.findViewById(R.id.imageView);
        TextView txtNombre = view.findViewById(R.id.txtNombreFragment);
        TextView txtSexo = view.findViewById(R.id.txtSexoFragment);
        TextView txtEspecie = view.findViewById(R.id.txtEspecieFragment);
        TextView txtProfesion = view.findViewById(R.id.txtProfesionFragment);
        TextView txtVida = view.findViewById(R.id.txtVida);
        TextView txtMagia = view.findViewById(R.id.txtMagia);
        TextView txtFuerza = view.findViewById(R.id.txtFuerza);
        TextView txtVelocidad = view.findViewById(R.id.txtVelocidad);

        txtNombre.setText(nombre_);
        txtSexo.setText(sexo_);

        Random random = new Random();
        int vida = random.nextInt(101);
        int magia = random.nextInt(11);
        int fuerza = random.nextInt(21);
        int velocidad = random.nextInt(6);
        txtVida.setText(String.valueOf(vida));
        txtMagia.setText(String.valueOf(magia));
        txtFuerza.setText(String.valueOf(fuerza));
        txtVelocidad.setText(String.valueOf(velocidad));

        //Hombres
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.elfoarquero);
            txtEspecie.setText(getString(R.string.Elf));
            txtProfesion.setText(getString(R.string.Arquer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.elfoguerrero);
            txtEspecie.setText(getString(R.string.Elf));
            txtProfesion.setText(getString(R.string.Guerrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.elfomago);
            txtEspecie.setText(getString(R.string.Elf));
            txtProfesion.setText(getString(R.string.Mag));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.elfoherrero);
            txtEspecie.setText(getString(R.string.Elf));
            txtProfesion.setText(getString(R.string.Herrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.elfominero);
            txtEspecie.setText(getString(R.string.Elf));
            txtProfesion.setText(getString(R.string.Miner));
        }

        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.enanoarquero);
            txtEspecie.setText(getString(R.string.Enan));
            txtProfesion.setText(getString(R.string.Arquer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.enanoguerrero);
            txtEspecie.setText(getString(R.string.Enan));
            txtProfesion.setText(getString(R.string.Guerrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.enanomago);
            txtEspecie.setText(getString(R.string.Enan));
            txtProfesion.setText(getString(R.string.Mag));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.enanoherrero);
            txtEspecie.setText(getString(R.string.Enan));
            txtProfesion.setText(getString(R.string.Herrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.enanominero);
            txtEspecie.setText(getString(R.string.Enan));
            txtProfesion.setText(getString(R.string.Miner));
        }

        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.hobbitarquero);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Arquer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.hobbitguerrero);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Guerrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.hobbitmago);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Mag));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.hobbitherrero);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Herrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.hobbitminero);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Miner));
        }

        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.humanoarquero);
            txtEspecie.setText(getString(R.string.Human));
            txtProfesion.setText(getString(R.string.Arquer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.humanoguerrero);
            txtEspecie.setText(getString(R.string.Human));
            txtProfesion.setText(getString(R.string.Guerrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.humanomago);
            txtEspecie.setText(getString(R.string.Human));
            txtProfesion.setText(getString(R.string.Mag));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.humanoherrero);
            txtEspecie.setText(getString(R.string.Human));
            txtProfesion.setText(getString(R.string.Herrer));
        }
        if(sexo_.equals(getString(R.string.hombre))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.humanominero);
            txtEspecie.setText(getString(R.string.Human));
            txtProfesion.setText(getString(R.string.Miner));
        }

        //Mujeres
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.elfaarquera);
            txtEspecie.setText(getString(R.string.Elfa));
            txtProfesion.setText(getString(R.string.Arquera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.elfaguerrera);
            txtEspecie.setText(getString(R.string.Elfa));
            txtProfesion.setText(getString(R.string.Guerrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.elfamaga);
            txtEspecie.setText(getString(R.string.Elfa));
            txtProfesion.setText(getString(R.string.Maga));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.elfaherrera);
            txtEspecie.setText(getString(R.string.Elfa));
            txtProfesion.setText(getString(R.string.Herrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Elfo))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.elfaminera);
            txtEspecie.setText(getString(R.string.Elfa));
            txtProfesion.setText(getString(R.string.Minera));
        }

        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.enanaarquera);
            txtEspecie.setText(getString(R.string.Enana));
            txtProfesion.setText(getString(R.string.Arquera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.enanaguerrera);
            txtEspecie.setText(getString(R.string.Enana));
            txtProfesion.setText(getString(R.string.Guerrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.enanamaga);
            txtEspecie.setText(getString(R.string.Enana));
            txtProfesion.setText(getString(R.string.Maga));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.enanaherrera);
            txtEspecie.setText(getString(R.string.Enana));
            txtProfesion.setText(getString(R.string.Herrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Enano))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.enanaminera);
            txtEspecie.setText(getString(R.string.Enana));
            txtProfesion.setText(getString(R.string.Minera));
        }

        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.hobbitarquera);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Arquera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.hobbitguerrera);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Guerrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.hobbitmaga);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Maga));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.hobbitherrera);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Herrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Hobbit))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.hobbitminera);
            txtEspecie.setText(getString(R.string.Hobbit));
            txtProfesion.setText(getString(R.string.Minera));
        }

        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Arquero))) {
            imagen.setImageResource(R.drawable.humanaarquera);
            txtEspecie.setText(getString(R.string.Humana));
            txtProfesion.setText(getString(R.string.Arquera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Guerrero))) {
            imagen.setImageResource(R.drawable.humanaguerrera);
            txtEspecie.setText(getString(R.string.Humana));
            txtProfesion.setText(getString(R.string.Guerrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Mago))) {
            imagen.setImageResource(R.drawable.humanamaga);
            txtEspecie.setText(getString(R.string.Humana));
            txtProfesion.setText(getString(R.string.Maga));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Herrero))) {
            imagen.setImageResource(R.drawable.humanaherrera);
            txtEspecie.setText(getString(R.string.Humana));
            txtProfesion.setText(getString(R.string.Herrera));
        }
        if(sexo_.equals(getString(R.string.mujer))&&especie_.equals(getString(R.string.Humano))&&profesion_.equals(getString(R.string.Minero))) {
            imagen.setImageResource(R.drawable.humanaminera);
            txtEspecie.setText(getString(R.string.Humana));
            txtProfesion.setText(getString(R.string.Minera));
        }
    }
    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        try {
            onInterface = (OnInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnInterface");
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnVolver) {
            onInterface.onFragmentoVolver();
            getParentFragmentManager().popBackStack();

        }
    }
}
