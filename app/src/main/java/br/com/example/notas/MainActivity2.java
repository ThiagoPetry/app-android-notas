package br.com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtNome = (TextView) findViewById(R.id.txtEstudanteResultado);
        TextView txtMedia = (TextView) findViewById(R.id.txtMediaResultado);
        TextView txtSituacao = (TextView) findViewById(R.id.txtSituacaoResultado);

        Intent it = getIntent();

        Double media;
        if(it != null) {
            Bundle params = it.getExtras();
            if(params != null) {
                txtNome.setText(params.getString("Nome"));

                media = ((params.getDouble("Nota1") + params.getDouble("Nota2") + params.getDouble("Nota3") + params.getDouble("Nota4")) / 4);
                txtMedia.setText(media.toString());

                txtSituacao.setText(media >= 7 ? "Aprovado" : media >= 4.5 && media < 7 ? "Em exame" : "Reprovado");
            }
        }

        Button btnRetorna = (Button) findViewById(R.id.btnVoltar);
        btnRetorna.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}