package vn.edu.vnu.hus.caro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import vn.edu.vnu.hus.caro.R;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2, btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button6);
        btn2 = (Button) findViewById(R.id.button5);
        btnTest = this.findViewById(R.id.btnTest);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, vn.edu.vnu.hus.caro.view.home.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, vn.edu.vnu.hus.caro.view.register.class);
                MainActivity.this.startActivity(intent);
            }

        });


        //Bắt sự kiện cho nút test.
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testIntent = new Intent(MainActivity.this, vn.edu.vnu.hus.caro.view.Test.class);
                MainActivity.this.startActivity(testIntent);
            }
        });

    }
}