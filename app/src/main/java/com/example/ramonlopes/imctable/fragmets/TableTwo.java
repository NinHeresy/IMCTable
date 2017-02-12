package com.example.ramonlopes.imctable.fragmets;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ramonlopes.imctable.R;

import es.dmoral.toasty.Toasty;

/**
 * Created by Ramon Lopes on 10/02/2017.
 */

public class TableTwo extends Fragment implements View.OnClickListener {
    public Button btn, btnlimpar;
    private EditText edtPeso, edtAltura, edtidade;
    private static final int TIME_OUT = 3000;
    private static final int MSG_DISMISS_DIALOG = 0;
    private AlertDialog mAlertDialog;
    public Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.layout_fragment_b, container, false);


        btn = (Button) mView.findViewById(R.id.submit);
        btnlimpar = (Button) mView.findViewById(R.id.btnclear);
        edtAltura = (EditText) mView.findViewById(R.id.edt1);
        edtidade = (EditText) mView.findViewById(R.id.editIdade);
        edtPeso = (EditText) mView.findViewById(R.id.edt2);

        btnlimpar.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtAltura.getText().toString().length() == 0) {
                    Toasty.custom(getContext(), "Preencha o campo Altura !",
                            R.drawable.alert, ContextCompat.getColor(getContext(),
                                            R.color.White), ContextCompat.getColor(getContext(),
                                            R.color.colorPrimary),
                            Toast.LENGTH_LONG, true, true).show();
                    edtAltura.requestFocus();
                } else if (edtPeso.getText().toString().length() == 0) {
                    Toasty.custom(getContext(), "Preencha o campo Peso !",
                            R.drawable.alert, ContextCompat
                                    .getColor(getContext(), R.color.White), ContextCompat
                                    .getColor(getContext(), R.color.colorPrimary),
                            Toast.LENGTH_LONG, true, true).show();
                    edtPeso.requestFocus();
                } else if (edtidade.getText().toString().length() == 0) {
                    Toasty.custom(getContext(), "Preencha o campo Idade !",
                            R.drawable.alert, ContextCompat
                                    .getColor(getContext(), R.color.White),
                            ContextCompat.getColor(getContext(), R.color.colorPrimary),
                            Toast.LENGTH_LONG, true, true).show();
                    //edtidade.setError("Campo Peso em branco !");
                    //btn.setEnabled(false);
                    edtidade.requestFocus();
                } else {
                    calcChild();
                }
            }
        });
        return mView;
    }

    @Override
    public void onClick(View v) {
        edtAltura.getText().clear();
        edtPeso.getText().clear();
        edtidade.getText().clear();
    }

    public void calcChild() {

        Double resultadoImc;
        float altura, peso;

        altura = Float.parseFloat(edtAltura.getText().toString());
        peso = Float.parseFloat(edtPeso.getText().toString());

        resultadoImc = peso / Math.pow(altura, 2);
        final String resultIMC = String.format("%.2f", resultadoImc);


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        if (resultadoImc < 17) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("MUITO ABAIXO DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 50kg e 60kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 17) || (resultadoImc <= 18.49)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("ABAIXO DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 18.5) || (resultadoImc <= 24.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("Parabéns, voce está no peso ideal!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 25) || (resultadoImc <= 29.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("ACIMA DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 30) || (resultadoImc <= 34.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("OBESIDADE I!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 35) || (resultadoImc <= 39.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("OBESIDADE II (SEVERA)!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("OBESIDADE III (MÓBIDA)\n" +
                    "Para sua altura, o peso ideal seria entre 45Kg e 69Kg\n" +
                    "Resultado: " + resultIMC);

        }
        alertDialogBuilder.setNegativeButton("Compartilhar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Fiz o meu IMC e o resultado foi " + resultIMC + "." +
                        "http://www.calculoimc.com.br/");
                startActivity(Intent.createChooser(share, "Compartilhar via..."));

            }
        });
        alertDialogBuilder.setPositiveButton("Correto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


}