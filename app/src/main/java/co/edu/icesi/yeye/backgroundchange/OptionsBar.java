package co.edu.icesi.yeye.backgroundchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OptionsBar extends AppCompatActivity {

    private Button btn_cambiarTema;

    private Button btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_bar);
    }


    @Override
    protected void onStart() {
        super.onStart();
        btn_cambiarTema= findViewById(R.id.btn_cambiarTema);
        btn_cambiarTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OptionsBar.this, ChangeBackground.class);
                if(getIntent().getExtras()!=null){
                    i.putExtra("color",getIntent().getExtras().getInt("color"));
                }
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Click en cambiar tema", Toast.LENGTH_SHORT).show();
            }
        });

        btn_salir = findViewById(R.id.btn_salir);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });
    }

}
