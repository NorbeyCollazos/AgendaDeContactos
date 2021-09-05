package com.recycler.agendacontactos.views.editar;

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
import com.recycler.agendacontactos.presenters.editar.EditarContactoPresenter;

public class EditarContactoFragment extends Fragment implements IEditarContactoFragment{

    EditText etNombre;
    EditText etTelefono;
    EditText etCorreo;
    Button btnEditar;
    EditarContactoPresenter presenter;

    public EditarContactoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_contacto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int idContacto = getArguments().getInt("id");

        presenter = new EditarContactoPresenter(this, getActivity());

        etNombre = view.findViewById(R.id.etNombre);
        etTelefono = view.findViewById(R.id.etTelefono);
        etCorreo = view.findViewById(R.id.etCorreo);
        btnEditar = view.findViewById(R.id.btnEditarContacto);

        presenter.mostrarContacto(idContacto);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString().trim();
                String telefono = etTelefono.getText().toString().trim();
                String correo = etCorreo.getText().toString().trim();
                presenter.editarContacto(
                        idContacto,
                        nombre,
                        telefono,
                        correo
                );
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
        getActivity().onBackPressed();
    }

    @Override
    public void mensajeEditado(String mensaje) {
        Snackbar snackbar = Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorRegistrado));
        snackbar.show();
    }

    @Override
    public void mostrarContacto(String nombre, String telefono, String correo, String direccion, String profesion, String imagen) {
        etNombre.setText(nombre);
        etTelefono.setText(telefono);
        etCorreo.setText(correo);
    }
}