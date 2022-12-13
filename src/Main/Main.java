package Main;

import DAO.*;
import Model.*;
import database.JDBCUtil;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ThucDonModel> list = ThucDonDAO.getInstance().selectAll();
        for(ThucDonModel chiNhanhModel : list) {
            System.out.println(chiNhanhModel.toString());
        }
//        ChiNhanhModel find = new ChiNhanhModel();
//        find.setMaChiNhanh("CN000001");
//        find.setMaDoiTac("DT000001");
//        ChiNhanhModel cn2 = ChiNhanhDAO.getInstance().selectById(find);
//        System.out.println(cn2);
    }
}
