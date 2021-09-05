package com.recycler.agendacontactos.views.agregar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.recycler.agendacontactos.R;
import com.recycler.agendacontactos.presenters.agregar.AgregarContactoPresenter;

public class AgregarContactoFragment extends Fragment implements IAgregarContactoFragment{

    EditText etNombre;
    EditText etTelefono;
    EditText etCorreo;

    AgregarContactoPresenter presenter;

    public AgregarContactoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_contacto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new AgregarContactoPresenter(this, getActivity());

        etNombre = view.findViewById(R.id.etNombre);
        etTelefono = view.findViewById(R.id.etTelefono);
        etCorreo = view.findViewById(R.id.etCorreo);

        final Button btnRegistrarContacto = view.findViewById(R.id.btnRegistrarContacto);
        btnRegistrarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString().trim();
                String telefono = etTelefono.getText().toString().trim();
                String correo = etCorreo.getText().toString().trim();

                presenter.registrarContacto(nombre,telefono,correo,null,null,null);
            }
        });

    }

    @Override
    public void mensajeError(String mensaje) {
        Snackbar snackbar = Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorError));
        snackbar.show();
    }

    @Override
    public void mensajeSuccess(String mensaje) {
        Snackbar snackbar = Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorSucces));
        snackbar.show();
    }

    @Override
    public void mensajeRegistrado(String mensaje) {
        Snackbar snackbar = Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorRegistrado));
        snackbar.show();
    }

    @Override
    public void limpiarCampos() {
        etNombre.setText("");
        etTelefono.setText("");
        etCorreo.setText("");
        etNombre.requestFocus();
    }
}