package br.com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = (Button) findViewById(R.id.btn);
        btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, MainActivity2.class);

        EditText nome = (EditText) findViewById(R.id.txtNome);
        EditText nota1 = (EditText) findViewById(R.id.valorNota1);
        EditText nota2 = (EditText) findViewById(R.id.valorNota2);
        EditText nota3 = (EditText) findViewById(R.id.valorNota3);
        EditText nota4 = (EditText) findViewById(R.id.valorNota4);

        Bundle params = new Bundle();
        params.putString("Nome", nome.getText().toString());
        params.putDouble("Nota1", Double.parseDouble(nota1.getText().toString()));
        params.putDouble("Nota2", Double.parseDouble(nota2.getText().toString()));
        params.putDouble("Nota3", Double.parseDouble(nota3.getText().toString()));
        params.putDouble("Nota4", Double.parseDouble(nota4.getText().toString()));
        it.putExtras(params);

        startActivity(it);
    }
}