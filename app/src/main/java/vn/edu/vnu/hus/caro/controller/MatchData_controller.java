package vn.edu.vnu.hus.caro.controller;

import vn.edu.vnu.hus.caro.common.common;
import vn.edu.vnu.hus.caro.model.MatchData_model;
import vn.edu.vnu.hus.caro.model.Match_model;

public class MatchData_controller
{

    //Hàm tạo dữ liệu cho trận đấu
    public void CreateDataAction(Match_model mMatch, int row, int column)
    {
        MatchData_model mMatchDate = new MatchData_model(row,column);
       try
       {
           mMatchDate.CreateData(mMatch);
       }
       catch (Exception ex)
       {
           ex.printStackTrace();
       }


    }

    //Hàm cập nhật giá trị cho một ô
    public void UpdateDataAction(Match_model mMatch, String row, String col, int val)
    {
        MatchData_model mMatchData = new MatchData_model(common.CHIEU_RONG, common.CHIEU_CAO);

        try
        {
            //Gọi hàm cập nhật từ Model
                mMatchData.UpdateNote(mMatch,row,col,val);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    //Hàm xóa toàn bộ dữ liệu của trận đấu.
    public void DeleteDataAction(Match_model mMatch)
    {
        try
        {
            MatchData_model mMatchData = new MatchData_model();
            mMatchData.DeleteData(mMatch);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
