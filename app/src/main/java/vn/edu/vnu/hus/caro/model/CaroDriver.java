package vn.edu.vnu.hus.caro.model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


//Lớp này khởi tại kết nối đến Database trên FireBase
public class CaroDriver
{
    protected FirebaseDatabase dbCaro;

    //Các hàm thao tác với thuộc tính
    public FirebaseDatabase getDbCaro()
    {
        return this.dbCaro;
    }

    public void setDbCaro(FirebaseDatabase db)
    {
        this.dbCaro = db;
    }

    //Hàm khởi dựng contructor
    public CaroDriver()
    {
        connectDB();
    }

    public FirebaseDatabase connectDB()
    {
        //lấy đối tượng FirebaseDatabase
        return this.dbCaro = FirebaseDatabase.getInstance();


    }
}
