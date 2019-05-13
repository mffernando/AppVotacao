package com.fernando.appvotacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupCandidatos;
    private ImageView imageViewCandidato;
    private Integer[] fotoCandidatos = {R.drawable.marina, R.drawable.bolsonaro, R.drawable.ciro, R.drawable.daciolo};

    private Button buttonVotar;
    private Toast toast;
    private TextView textViewMarina, textViewBolsonaro, textViewCiro, textViewDaciolo;

    private int marina =0, bolsonaro = 0, ciro =0, daciolo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // botao radio para escolher o candidato
        this.imageViewCandidato = (ImageView) findViewById(R.id.imageViewCandidato);
        this.radioGroupCandidatos = (RadioGroup) findViewById(R.id.radioGroupCandidatos);

        this.radioGroupCandidatos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) radioGroupCandidatos.findViewById(checkedId);
                int index = radioGroupCandidatos.indexOfChild(radioButton);
                imageViewCandidato.setImageResource(fotoCandidatos[index]);
            }
        });

        //botao votar / inicializar
        this.buttonVotar = (Button) findViewById(R.id.buttonVotar);
        this.textViewMarina = (TextView) findViewById(R.id.textViewMarina);
        this.textViewBolsonaro = (TextView) findViewById(R.id.textViewBolsonaro);
        this.textViewCiro = (TextView) findViewById(R.id.textViewCiro);
        this.textViewDaciolo = (TextView) findViewById(R.id.textViewDaciolo);

        this.buttonVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    RadioButton rb = (RadioButton) radioGroupCandidatos.findViewById(radioGroupCandidatos.getCheckedRadioButtonId());
                    Toast.makeText(MainActivity.this, "Você votou em " + rb.getText().toString() + "!", Toast.LENGTH_SHORT).show();

                    switch (radioGroupCandidatos.getCheckedRadioButtonId())
                    {
                        case R.id.rbtMarina :
                            marina++;
                            textViewMarina.setText(rb.getText().toString() + " " + marina);
                            break;

                        case R.id.rbtBolsonaro :
                            bolsonaro++;
                            textViewBolsonaro.setText(rb.getText().toString() + " " + bolsonaro);
                            break;

                        case R.id.rbtCiro :
                            ciro++;
                            textViewCiro.setText(rb.getText().toString() + " " + ciro);
                            break;

                        case R.id.rbtDaciolo :
                            daciolo++;
                            textViewDaciolo.setText(rb.getText().toString() + " " + daciolo);
                            break;

                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Por favor, selecione um candidato!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
