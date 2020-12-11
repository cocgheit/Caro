package vn.edu.vnu.hus.caro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_login,btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, vn.edu.vnu.hus.caro.view.home.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, vn.edu.vnu.hus.caro.view.register.class);
            MainActivity.this.startActivity(intent);
        }
    });

    }
}