package vn.edu.vnu.hus.caro.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import android.util.Log;


import java.util.ArrayList;
import java.util.HashMap;

public class Gamer_model extends CaroDriver
{
    private String GamerID;
    private String GamerName;
    private String EMail;
    private String Password;
    private int Status;

    //các hàm thao tác với biến nội tại.
    public void setGammerID(String value)
    {
        this.GamerID = value;
    }
    public String getGammerID()
    {
        return this.GamerID;
    }
    public void setGamerName(String value)
    {
        this.GamerName = value;
    }
    public String getGamerName()
    {
        return this.GamerName;
    }
    public void setEMail(String value)
    {
        this.EMail = value;
    }
    public String getEMail()
    {
        return this.EMail;
    }
    public void setPassword(String value)
    {
        this.Password = value;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public void setStatus(int value)
    {
        this.Status = value;
    }
    public int getStatus()
    {
        return this.Status;
    }

    //Các hàm khởi dựng Contructor

    public Gamer_model()
    {
        super();
        this.GamerID = "";
        this.GamerName = "";
        this.EMail = "";
        this.Password = "";
        this.Status = 0;

    }

    public Gamer_model(String id, String name, String mail, String passwd, int sta )
    {
        super();
        this.GamerID = id;
        this.GamerName = name;
        this.EMail = mail;
        this.Password = passwd;
        this.Status = sta;
    }

    //Hàm thêm một Game thủ
    public void InsertGamer(Gamer_model obj)
    {

        //Kết nối tới node có tên là GameThu (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("Gamers");

        //Lấy ID tự động cho một Game Thủ.
        obj.setGammerID(myRef.push().getKey());

        //Cập nhật lên CSDL FireBase. Tức là tạo một nút trên CSDL
        myRef.child(obj.getGammerID()).child("Name").setValue(obj.getGamerName());
        myRef.child(obj.getGammerID()).child("Email").setValue(obj.getEMail());
        myRef.child(obj.getGammerID()).child("Password").setValue(obj.getPassword());
        myRef.child(obj.getGammerID()).child("Status").setValue(obj.getStatus());

    }

    //Hàm Cập nhật dữ liệu của một nút Game thủ.
    public void UpdateGamer(Gamer_model obj)
    {
        //Kết nối tới node có tên là GameThu (node này do ta định nghĩa trong CSDL Firebase.
        // Nếu chưa tồn tại hệ thống sẽ tự tạo thêm)
        DatabaseReference myRef = this.dbCaro.getReference("Gamers");

        //Cập nhật lên CSDL FireBase. Tức là tạo một nút trên CSDL
        myRef.child(obj.getGammerID()).child("Name").setValue(obj.getGamerName());
        myRef.child(obj.getGammerID()).child("Email").setValue(obj.getEMail());
        myRef.child(obj.getGammerID()).child("Password").setValue(obj.getPassword());
        myRef.child(obj.getGammerID()).child("Status").setValue(obj.getStatus());
    }

    //Hàm Xóa một Game thủ;
    public void DeleteGamer(Gamer_model obj)
    {
        //Kết nối tới node có tên là GameThu (node này do ta định nghĩa trong CSDL Firebase.)
        DatabaseReference myRef = this.dbCaro.getReference("Gamers");

        //Xóa nút trên CSDL
        myRef.child(obj.getGammerID()).removeValue();
    }

    //Hàm lấy danh sách toàn bộ Game Thủ
    public void ListGamer()
    {
        //Kết nối tới node có tên là GameThu (node này do ta định nghĩa trong CSDL Firebase.)
        DatabaseReference myRef = this.dbCaro.getReference("GameThu");

        //ArrayList<GameThu> gamers = null;
        //truy suất và lắng nghe sự thay đổi dữ liệu
        myRef.addValueEventListener(new ValueEventListener() {

            ArrayList<Gamer_model> gamers = null;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gamers = new ArrayList<>();
                //vòng lặp để lấy dữ liệu khi có sự thay đổi trên Firebase
                for (DataSnapshot data: dataSnapshot.getChildren())
                {
                    Gamer_model gamer = data.getValue(Gamer_model.class);
                    gamers.add(gamer);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }

    //Hàm lấy thông toàn bộ thông tin của một Game Thủ
    public void getGamer(String key)
    {

        //Kết nối tới node có tên là GameThu (node này do ta định nghĩa trong CSDL Firebase.)
        DatabaseReference myRef = this.dbCaro.getReference("GameThu");

        myRef.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    //nó trả về 1 DataSnapShot, mà giá trị đơn nên gọi getValue trả về 1 HashMap
                    HashMap<String,Object> hashMap= (HashMap<String, Object>) dataSnapshot.getValue();
                    //HashMap này sẽ có kích  thước bằng số Node con bên trong node truy vấn
                    //mỗi phần tử có key là name được định nghĩa trong cấu trúc Json của Firebase

                }
                catch (Exception ex)
                {
                    Log.e("LOI_JSON",ex.toString());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("LOI_CHITIET", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }


}
