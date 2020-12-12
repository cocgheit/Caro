package vn.edu.vnu.hus.caro.model;

import com.google.firebase.database.DatabaseReference;

public class MatchDetails_model extends CaroDriver
{
    private String MatchDetailID;
    private String GamerID;
    private String MatchID;
    private  int Score; //Điểm số

    //Các hàm thao tác với thuộc tính.

    public String getMachDetailID ()
    {
        return this.MatchDetailID;
    }

    public void setMatchDetailID (String value)
    {
        this.MatchDetailID = value;
    }

    public void setGamerID(String value)
    {
        this.GamerID = value;
    }
    public String getGamerID() {
        return this.GamerID;
    }

    public void  setMatchID(String value)
    {
        this.MatchID = value;
    }

    public String getMatchID()
    {
        return this.MatchID;
    }

    public void setScore(int value)
    {
        this.Score = value;
    }

    public int getScore()
    {
        return this.Score;
    }

    //Các hàm khởi dựng contructor
    public MatchDetails_model()
    {
        super();
    }
    public MatchDetails_model(String mDetailID, String mID, String gID, int number)
    {
        super();
        this.MatchDetailID = mDetailID;
        this.MatchID = mID;
        this.GamerID = gID;
        this.Score = number;
    }

    //Thêm một bản ghi chi tiết trận đấu.
    public void AddMatchDetail(MatchDetails_model obj)
    {
        //Kết nối tới node có tên là MatchDetail (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("MatchDetails");

        //Lấy ID tự động cho một MatchDetail.
        obj.setMatchDetailID(myRef.push().getKey());

        //Cập nhật vào CSDL
        myRef.child(obj.getMachDetailID()).child("MatchID:").setValue(obj.getMatchID());
        myRef.child(obj.getMachDetailID()).child("GamerID:").setValue(obj.getGamerID());
        myRef.child(obj.getMachDetailID()).child("Score:").setValue(obj.getScore());

    }

    //Hàm cập nhật một bản ghi Chi tiết trận đấu.
    public void UpdateMatchDetail(MatchDetails_model obj)
    {
        //Kết nối tới node có tên là MatchDetail (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("MatchDetails");

        //Cập nhật vào CSDL
        myRef.child(obj.getMachDetailID()).child("MatchID:").setValue(obj.getMatchID());
        myRef.child(obj.getMachDetailID()).child("GamerID:").setValue(obj.getGamerID());
        myRef.child(obj.getMachDetailID()).child("Score:").setValue(obj.getScore());
    }

    //Hàm xóa một bản ghi Chi tiết trận đấu.
    public void DeleteMatchDetail(MatchDetails_model obj)
    {
        //Kết nối tới node có tên là MatchDetail (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("MatchDetails");

        //Xóa nút trên CSDL
        myRef.child(obj.getMachDetailID()).removeValue();

    }

}
