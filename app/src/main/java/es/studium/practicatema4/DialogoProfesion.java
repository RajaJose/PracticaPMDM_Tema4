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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DialogoProfesion extends DialogFragment {

    OnInterface onInterface;
    Spinner profesion;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_profesion, null);
        profesion = myView.findViewById(R.id.spinnerProfesion);
        String[] profesionSP = {
                getString(R.string.seleccione),
                getString(R.string.Arquero),
                getString(R.string.Guerrero),
                getString(R.string.Mago),
                getString(R.string.Herrero),
                getString(R.string.Minero)
        };
        builder.setView(myView)
                .setTitle(R.string.tituloDialogoProfesion)
                .setPositiveButton(R.string.btnSiguiente, null)
                .setNegativeButton(R.string.btnCancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, profesionSP);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profesion.setAdapter(aa);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (profesion.getSelectedItem().equals(getString(R.string.seleccione)))
                {
                    Toast.makeText(getContext(), R.string.errorProfesion, Toast.LENGTH_SHORT).show();
                    profesion.requestFocus();
                }
                else {
                    onInterface.onProfesion(profesion.getSelectedItem().toString());
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
