package es.studium.practicatema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment  {

    DialogoSexo dialogoSexo;
    OnInterface onInterface;
    EditText nombre;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_nombre, null);
        nombre = myView.findViewById(R.id.txtProfesion);
        builder.setView(myView)
                .setTitle(R.string.tituloDialogoNombre)
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
                if (nombre.getText().toString().isEmpty())
                {
                    nombre.setError(getString(R.string.errorNombre));
                    nombre.requestFocus();
                }
                else {
                    onInterface.onNombre(nombre.getText().toString());
                    dialogoSexo = new DialogoSexo();
                    dialogoSexo.setCancelable(false);
                    dialogoSexo.show(getParentFragmentManager(), "");
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
