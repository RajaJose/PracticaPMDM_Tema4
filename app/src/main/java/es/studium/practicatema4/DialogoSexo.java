package es.studium.practicatema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoSexo extends DialogFragment {
    DialogoEspecie dialogoEspecie;
    OnInterface onInterface;
    RadioButton rdHombre,rdMujer;
    RadioGroup rdGenero;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_sexo, null);
        rdGenero = myView.findViewById(R.id.rdGenero);
        rdHombre = myView.findViewById(R.id.rdHombre);
        rdMujer = myView.findViewById(R.id.rdMujer);
        builder.setView(myView)
                .setTitle(R.string.tituloDialogoSexo)
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
                if (rdGenero.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getContext(),getString(R.string.errorSexo), Toast.LENGTH_SHORT).show();
                }
                else {
                    if (rdHombre.isChecked()) {
                        onInterface.onSexo(getString(R.string.hombre));
                    }else if (rdMujer.isChecked())
                    {
                        onInterface.onSexo(getString(R.string.mujer));
                    }
                    dialogoEspecie = new DialogoEspecie();
                    dialogoEspecie.setCancelable(false);
                    dialogoEspecie.show(getParentFragmentManager(), "");
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
