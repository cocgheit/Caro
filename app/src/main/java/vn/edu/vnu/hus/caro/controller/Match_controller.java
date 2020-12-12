package vn.edu.vnu.hus.caro.controller;

import vn.edu.vnu.hus.caro.model.Match_model;

public class Match_controller
{

    //Hàm thêm một tên trận đấu vào CSDL
    public void AddMatchAction(String matchname)
    {
        Match_model mMatch = new Match_model();
        mMatch.setMatchName(matchname);

        try
        {
            //Gọi hàm Thêm trận đấu từ Model
            mMatch.AddMatch(mMatch);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Hàm Cập nhật tên một trận đấu
    public void UpdateMatchAction (Match_model obj)
    {
        try
        {
            //gọi hàm Update từ model
            obj.UpdateMatch(obj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Hàm xóa một Trận đấu.
    public void DeleteMatchAction(Match_model obj)
    {
        try
        {
            //gọi hàm Delte từ model
            obj.DeleteMatch(obj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
