package co.edu.icesi.yeye.backgroundchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ChangeBackground extends AppCompatActivity {

    private Button btn_white;
    private Button btn_black;

    private LinearLayout layout_changeBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);


        layout_changeBackground=findViewById(R.id.layout_changeBackground);

        btn_white=findViewById(R.id.btn_white);
        btn_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_changeBackground.setBackgroundResource(R.color.white);

                getIntent().putExtra("color",R.color.white);

                Intent intent= new Intent(ChangeBackground.this, MainActivity.class);
                intent.putExtra("color",R.color.white);
                startActivity(intent);

            }
        });

        btn_black=findViewById(R.id.btn_black);
        btn_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_changeBackground.setBackgroundResource(R.color.black);

                getIntent().putExtra("color",R.color.black);

                Intent intent= new Intent(ChangeBackground.this, MainActivity.class);
                intent.putExtra("color",R.color.black);
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        cambiarFondo();
    }

    public void cambiarFondo(){
        Bundle b = getIntent().getExtras();
        if(b!=null){
            int color=b.getInt("color");
            layout_changeBackground.setBackgroundResource(color);
        }
    }
}
