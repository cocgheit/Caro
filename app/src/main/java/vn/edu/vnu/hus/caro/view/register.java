package vn.edu.vnu.hus.caro.view;

import androidx.appcompat.app.AppCompatActivity;
import vn.edu.vnu.hus.caro.R;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.vnu.hus.caro.controller.*;
import vn.edu.vnu.hus.caro.common.*;

//cho phần test khong qua MVC
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import vn.edu.vnu.hus.caro.model.*;



public class register extends AppCompatActivity
{
    private EditText edtGamerId;
    private EditText edtGamerName;
    private EditText edtGamerPass;
    private EditText edtGamerEmail;
    private EditText edtGamerRePass;
    private Button btnRegister;
    private Button btnCancel;
    private TextView tTile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControls();

        //Xử lý sự kiện click nút.
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddGamer();
               // AddGamerNoMVC();
            }
        });
    }

    //Hàm add để test khong thông qua MVC
//    public void AddGamerNoMVC()
//    {
//
//        try {
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            //Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
//            DatabaseReference myRef = database.getReference("Gamers");
//
//
//            String gamerId = myRef.push().getKey();
//            String gamerName = this.edtGamerName.getText().toString();
//            String gamerPasswd = this.edtGamerPass.getText().toString();
//            String gamerEmail = this.edtGamerEmail.getText().toString();
//            int gamerStatus = common.RANH_ROI;
//
//            //sử dụng đối tượng
//            Gamer_model mGamer = new Gamer_model(gamerId,gamerName,gamerEmail,gamerPasswd,gamerStatus);
//
//            myRef.child(gamerId).setValue(mGamer);
//
////            myRef.child(gamerId).child("Name").setValue(gamerName);
////            myRef.child(gamerId).child("Password").setValue(gamerPasswd);
////            myRef.child(gamerId).child("Email").setValue(gamerEmail);
////            myRef.child(gamerId).child("Status").setValue(gamerStatus);
//
//            finish();
//        }
//        catch (Exception ex)
//        {
//            Toast.makeText(this,"Error:"+ex.toString(),Toast.LENGTH_LONG).show();
//        }
//    }

    //Hàm add
    public void AddGamer()
    {
        //this.tTile.setText("THÔNG TIN ĐĂNG KÝ");
        Gamer_controller cGamer = new Gamer_controller();
        String gamerName = this.edtGamerName.getText().toString();
        String gamerPass = this.edtGamerPass.getText().toString();
        String gamerEmail = this.edtGamerEmail.getText().toString();

        if (vaidate())
        {
            cGamer.AddGamerAction(gamerName,gamerPass,gamerEmail);
        }

        finish();
    }

    private void addControls() {

        this.edtGamerName = this.findViewById(R.id.txtGamerName);
        this.edtGamerPass = this.findViewById(R.id.txtPassword);
        this.edtGamerRePass = this.findViewById(R.id.txtRePassword);
        this.edtGamerEmail = this.findViewById(R.id.txtEmail);
        this.btnRegister = (Button) findViewById(R.id.bRegister);
        this.btnCancel = this.findViewById(R.id.bCancel);
        //this.tTile = this.findViewById(R.id.txtTitle);
        //this.edtGamerId = this.findViewById(R.id.txtGamerID);

    }

    //Hàm kiểm tra Dữ liệu đầu vào có hợp lệ không.
    private boolean vaidate()
    {
        boolean valid = true;
        String gamerName = this.edtGamerName.getText().toString();
        String gamerPass = this.edtGamerPass.getText().toString();
        String gamerRePass = this.edtGamerRePass.getText().toString();
        String gamerEmail = this.edtGamerEmail.getText().toString();

        //Kiểm tra hộp nhập Tên Game thủ
        if (gamerName.isEmpty() || gamerName.length() < 3)
        {
            this.edtGamerName.setError("Tên phải lớn hơn 3 ký tự");
            valid = false;
        }
        else
        {
            this.edtGamerName.setError(null);
        }

        //Kiểm tra hộp nhập Mật khẩu
        if (gamerPass.isEmpty() || gamerPass.length() < 4 )
        {
            this.edtGamerPass.setError("Mật khẩu phải lớn hơn 4 ký tự");
            valid = false;
        }
        else if(!gamerPass.equals(gamerRePass))
        {
            this.edtGamerPass.setError("Mật khẩu không giống nhau");
            valid = false;
        }
        else
        {
            this.edtGamerPass.setError(null);
        }

        //Kiểm tra hộp nhập lại mật khẩu
        if(gamerRePass.isEmpty() || edtGamerRePass.length() < 4)
        {
            this.edtGamerRePass.setError("Mật khẩu phải lớn hơn 4 ký tự");
            valid = false;
        }
        else if(!gamerPass.equals(gamerRePass))
        {
            this.edtGamerRePass.setError("Mật khẩu không giống nhau");
            valid = false;
        }
        else
        {
            this.edtGamerRePass.setError(null);
        }

        //Kiểm tra hộp nhập Email
        if (gamerEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(gamerEmail).matches())
        {
            this.edtGamerEmail.setError("Nhập đúng một địa chỉ Email");
            valid = false;
        }
        else
        {
            this.edtGamerEmail.setError(null);
        }

        return valid;
    }

}