package co.edu.icesi.yeye.backgroundchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView sideBar;

    private LinearLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sideBar = findViewById(R.id.sideBar);
        sideBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Intent intent = new Intent(MainActivity.this, OptionsBar.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Entra a la acción", 3000).show();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        Intent intent2 = new Intent(MainActivity.this, OptionsBar.class);
                        startActivity(intent2);
                        Toast.makeText(getApplicationContext(), "Entra a la acción", 3000).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "otra acción", 3000).show();
                        return false;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        cambiarColor();
    }

    public void cambiarColor(){
        mainActivity=findViewById(R.id.mainLayout);

        Bundle b=getIntent().getExtras();
        if(b!=null){
        int fondo = b.getInt("color");

        Intent intent= new Intent(MainActivity.this, OptionsBar.class);
        intent.putExtra("color",fondo);
        //Toast.makeText(getApplicationContext(), fondo, Toast.LENGTH_SHORT).show();

            mainActivity.setBackgroundResource(fondo);
        }

    }
}
