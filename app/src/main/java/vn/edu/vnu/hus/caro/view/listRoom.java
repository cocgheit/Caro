package vn.edu.vnu.hus.caro.view;

import androidx.appcompat.app.AppCompatActivity;
import vn.edu.vnu.hus.caro.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listRoom extends AppCompatActivity {
    ListView lvRoom;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);

    }
}