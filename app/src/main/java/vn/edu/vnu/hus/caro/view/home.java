package vn.edu.vnu.hus.caro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import vn.edu.vnu.hus.caro.R;

public class home extends AppCompatActivity {

    private RadioButton radioBtn_online;
    private RadioButton radioBtn_daugiai;
    private RadioButton radioBtn_dauvoimay;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        this.radioBtn_online = (RadioButton) this.findViewById(R.id.radioBtn_online);
        this.radioBtn_daugiai = (RadioButton) this.findViewById(R.id.radioBtn_daugiai);
        this.radioBtn_dauvoimay = (RadioButton) this.findViewById(R.id.radioBtn_dauvoimay);
        this.btn_next= (Button) this.findViewById(R.id.btn_next);
        this.radioBtn_online.setChecked(true);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioBtn_online.isChecked()){
                    Intent intent = new Intent(home.this, listRoom.class);
                    startActivity(intent);
                }

            }
        });


        }




}