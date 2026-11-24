package es.studium.practicatema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment {
    DialogoProfesion dialogoProfesion;
    OnInterface onInterface;
    Spinner especie;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_especie, null);
        especie = myView.findViewById(R.id.spinnerEspecie);
        String[] especieSP = {
                getString(R.string.seleccione),
                getString(R.string.Elfo),
                getString(R.string.Enano),
                getString(R.string.Hobbit),
                getString(R.string.Humano)
        };
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, especieSP);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        especie.setAdapter(aa);
        builder.setView(myView)
                .setTitle(R.string.tituloDialogoEspecie)
                .setPositiveButton(R.string.btnSiguiente, null)
                .setNegativeButton(R.string.btnCancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (especie.getSelectedItem().equals(getString(R.string.seleccione)))
                {
                    Toast.makeText(getContext(), getString(R.string.errorEspecie), Toast.LENGTH_SHORT).show();
                    especie.requestFocus();
                }
                else {
                    onInterface.onEspecie(especie.getSelectedItem().toString());
                    dialogoProfesion = new DialogoProfesion();
                    dialogoProfesion.setCancelable(false);
                    dialogoProfesion.show(getParentFragmentManager(), "");
                    dialog.dismiss();
                }
            }
        });
        return dialog;
    }
    @Override
    public void onStart(){
        super.onStart();

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

}
