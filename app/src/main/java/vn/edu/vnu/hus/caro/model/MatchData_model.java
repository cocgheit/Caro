package vn.edu.vnu.hus.caro.model;


import com.google.firebase.database.DatabaseReference;


public class MatchData_model extends CaroDriver
{

    //Khai báo các biến nội bộ
    private int row;
    private int col;
   // private String MatchName;

    //Các hàm thao tác với các biến nội tại.
    public int getRow()
    {
        return this.row;
    }

    public void setRow(int value)
    {
        this.row = value;
    }

    public int getCol ()
    {
        return this.col;
    }

    public void setCol(int value)
    {
        this.col =value;
    }

    //Các hàm khởi dựng contructor
    public MatchData_model(int r, int c)
    {
        //Gọi hàm khởi dựng của lớp cha để lấy kết nối đến DataBase trên Firebase.
        super();
        this.row = r;
        this.col = c;

    }

    public MatchData_model()
    {
        super();
    }


    //Hàm tạo dữ liệu mới cho ma trận
    public void CreateData(Match_model obj)
    {

        //Kết nối tới node có tên là Tên của trận đấu. (node này do ta định nghĩa trong CSDL Firebase.)
        DatabaseReference myRef = this.dbCaro.getReference("Matchs").child(obj.getMatchID()).child(obj.getMatchName());

        int i ;
        int j;
        for (i = 0; i <= this.row; i++)
            for(j = 0; j <= this.col; j++)
            {
                //Thực hiện thêm nút. Tức thêm gán giá trị cho cột trong ma trận
                myRef.child("row" + i).child("col" + j).setValue(0);
            }

    }

    //Hàm xóa hết dữ liệu  cho ma trận
    public void DeleteData(Match_model obj)
    {
        //Kết nối tới node có tên là Tên của trận đấu. (node này do ta định nghĩa trong CSDL Firebase.)
        DatabaseReference myRef = this.dbCaro.getReference("Matchs").child(obj.getMatchID());

        //Xóa dữ liệu trận đấu.
        myRef.child(obj.getMatchName()).removeValue();


    }

    //Hàm cập nhật dữ liệu cho một ô (node)
    public boolean UpdateNote(Match_model obj, String rowKey, String colKey ,int value)
    {

        boolean isOkay = true;
        //Kết nối tới node có tên là Tên của trận đấu. (node này do ta định nghĩa trong CSDL Firebase.)
        DatabaseReference myRef = this.dbCaro.getReference("Matchs").child(obj.getMatchID()).child(obj.getMatchName());

        try
        {
            //Thực hiện cập nhật.
            myRef.child(rowKey).child(colKey).setValue(value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            isOkay = false;
        }
        return isOkay;
    }


}
