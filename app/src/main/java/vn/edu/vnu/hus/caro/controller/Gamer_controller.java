package vn.edu.vnu.hus.caro.controller;
import vn.edu.vnu.hus.caro.model.*;
import vn.edu.vnu.hus.caro.common.*;

public class Gamer_controller
{

    //Hàm này load toàn bộ danh sách Game thủ lên listview
    public void indexAction()
    {

    }

    //Hàm này sẽ thêm một Game thủ lên CSDL
    public void AddGamerAction(String gName, String gPass, String gEmail)
    {
        //Khai báo đối tượng kết nối tới CSDL
        Gamer_model dbGamer = new Gamer_model();
        dbGamer.setGamerName(gName);

        //Mã hóa mật khẩu trước khi lưu lên hệ thống
        String tempPass = common.md5(gPass);
        dbGamer.setPassword(tempPass);
        dbGamer.setEMail(gEmail);
        dbGamer.setStatus(common.RANH_ROI);

        //gọi hàm Thêm dữ liệu
        dbGamer.InsertGamer(dbGamer);

    }

    //Hàm này sẽ cập nhật dữ liệu của một Game thủ. Khi đổi Mật khẩu
    public void UpdateGamerAction(Gamer_model obj, boolean isChangePasswd)
    {
        //Nếu đổi mật khẩu người dùng sẽ mã hóa mật khẩu trước khi lưu.
        if (isChangePasswd)
        {
            String tempPass = common.md5(obj.getPassword());

            try
            {
                //Gọi hàm cập nhật dữ liệu từ Model
                obj.UpdateGamer(obj);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }

    }

    //Hàm nạp chồng của phương thức cập nhật Game thủ.
    public void UpdateGamerAction(Gamer_model obj)
    {
        try
        {
            //gọi hàm cập nhật dữ liệu từ Model
            obj.UpdateGamer(obj);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //Hàm xóa một Game thủ
    public void DeleteGamerAction(Gamer_model obj)
    {

        try
        {
            //gọi hàm xóa 1 Game thủ trong model
            obj.DeleteGamer(obj);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //Hàm lấy danh sách một các Game thủ.

}
