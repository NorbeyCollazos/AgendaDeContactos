package com.recycler.agendacontactos.views.mostrar;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.recycler.agendacontactos.R;
import com.recycler.agendacontactos.db.ConstructorContactos;
import com.recycler.agendacontactos.presenters.mostrar.MostrarContactoPresenter;

public class MostrarContactoFragment extends Fragment implements IMostrarContactoFragment {

    private TextView tvNombre;
    private TextView tvNombreEncabezado;
    private TextView tvTelefono;
    private TextView tvCorreo;
    private Button btnEditar;
    private Button btnEliminar;

    private MostrarContactoPresenter presenter;

    public MostrarContactoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mostrar_contacto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int idContacto = getArguments().getInt("id");

        presenter = new MostrarContactoPresenter(this, getActivity());

        tvNombre = view.findViewById(R.id.tvNombre);
        tvNombreEncabezado = view.findViewById(R.id.tvNombreEncabezado);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvCorreo = view.findViewById(R.id.tvCorreo);
        btnEditar = view.findViewById(R.id.btnEditar);
        btnEliminar = view.findViewById(R.id.btnEliminar);

        presenter.mostrarContacto(idContacto);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", idContacto);
                Navigation.findNavController(view).navigate(R.id.editarContactoFragment, bundle);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertEliminarContacto(idContacto);
            }
        });

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
    public void mensajeError(String mensaje) {
        Snackbar snackbar = Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorError));
        snackbar.show();
    }

    @Override
    public void mostrarContacto(String nombre, String telefono, String correo, String direccion, String profesion, String imagen) {
        tvNombre.setText(nombre);
        tvNombreEncabezado.setText(nombre);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);
    }

    @Override
    public void alertEliminarContacto(final int idcontacto) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Eliminar contacto");
        builder.setMessage("¿Desea eliminar el contacto?");

        builder.setPositiveButton("Si, eliminar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                presenter.eliminarContacto(idcontacto);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}