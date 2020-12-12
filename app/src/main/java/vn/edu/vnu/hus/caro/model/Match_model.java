package vn.edu.vnu.hus.caro.model;

import com.google.firebase.database.DatabaseReference;

import vn.edu.vnu.hus.caro.common.common;
import vn.edu.vnu.hus.caro.controller.MatchData_controller;

public class Match_model extends CaroDriver
{
    private  String MatchName;
    private String MatchID;

    //Các hàm thao tác với biến nội tại
    public void setMatchID(String value)
    {
        this.MatchID = value;
    }
    public String getMatchID()
    {
        return this.MatchID;
    }

    public void setMatchName(String value)
    {
        this.MatchName = value;
    }
    public String getMatchName()
    {
        return this.MatchName;
    }

    //Các hàm khởi dựng contructor
    public Match_model()
    {
        super();
    }

    public Match_model(String mID, String mName)
    {
        super();
        this.MatchID = mID;
        this.MatchName = mName;
    }

    //Hàm tạo mới một bản ghi Trận đấu.
    public void AddMatch(Match_model obj)
    {
        //Kết nối tới node có tên là Matchs (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("Matchs");

        //Lấy ID tự động cho một MatchID.
        obj.setMatchID(myRef.push().getKey());

        //Cập nhật vào CSDL
        myRef.child(obj.getMatchID()).child("MatchName").setValue(obj.getMatchName());

        //Tạo dữ liệu cho trận đấu.
        MatchData_controller cMachData = new MatchData_controller();
        cMachData.CreateDataAction(obj, common.CHIEU_RONG,common.CHIEU_CAO);

    }

    //Hàm cập nhật một bản ghi Trận đấu.
    public void UpdateMatch(Match_model obj)
    {
        //Kết nối tới node có tên là Match (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("Matchs");

        //Cập nhật vào CSDL
        myRef.child(obj.getMatchID()).child("MatchName").setValue(obj.getMatchName());
    }

    //Hàm xóa một bản ghi Trận đấu.
    public void DeleteMatch(Match_model obj)
    {
        //Kết nối tới node có tên là Match (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = this.dbCaro.getReference("Matchs");

        //Xóa nút trên CSDL
        myRef.child(obj.getMatchID()).removeValue();

    }
}
