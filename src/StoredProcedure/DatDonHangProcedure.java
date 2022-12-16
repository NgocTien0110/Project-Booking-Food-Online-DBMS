package StoredProcedure;

import java.sql.*;

public class DatDonHangProcedure {
    private Connection con;
    public DatDonHangProcedure() {
        con = database.JDBCUtil.getConnection();
    }

    public int SP_LUDatDonHang(String tinhTrangDonHang, double phiDonHang, String hinhThucPayment, String DCGiaoHang,
                               float phiVanChuyen, String maChiNhanh, String maDoiTac,String maKH, int SLMonDat,
                               String tuyChon, String maMonAn) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_DatDonHangMonAn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, tinhTrangDonHang);
            pst.setDouble(2, phiDonHang);
            pst.setString(3, hinhThucPayment);
            pst.setString(4,DCGiaoHang);
            pst.setFloat(5,phiVanChuyen);
            pst.setDate(6, null);
            pst.setString(7,maChiNhanh);
            pst.setString(8,maDoiTac);
            pst.setString(9, null);
            pst.setString(10,maKH);
            pst.setString(11,null);
            pst.setInt(12, SLMonDat);
            pst.setString(13,tuyChon);
            pst.setString(14, maMonAn);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
    public int SP_DatDonHangMonAnXuLyLu(String tinhTrangDonHang, double phiDonHang, String hinhThucPayment, String DCGiaoHang,
                               float phiVanChuyen, String maChiNhanh, String maDoiTac,String maKH, int SLMonDat,
                               String tuyChon, String maMonAn) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_DatDonHangMonAnXuLyLu(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, tinhTrangDonHang);
            pst.setDouble(2, phiDonHang);
            pst.setString(3, hinhThucPayment);
            pst.setString(4,DCGiaoHang);
            pst.setFloat(5,phiVanChuyen);
            pst.setDate(6, null);
            pst.setString(7,maChiNhanh);
            pst.setString(8,maDoiTac);
            pst.setString(9, null);
            pst.setString(10,maKH);
            pst.setString(11,null);
            pst.setInt(12, SLMonDat);
            pst.setString(13,tuyChon);
            pst.setString(14, maMonAn);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
}
