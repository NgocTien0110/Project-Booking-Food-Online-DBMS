package Model;

import java.sql.Time;
import java.util.Date;

public class ChiNhanhModel {
    private String MaChiNhanh;
    private String MaDoiTac;
    private String TenChiNhanh;
    private String DCChiNhanh;
    private String TinhTrangHoatDong;
    private Time ThoiGianMoCua;
    private double DoanhThuThang;
    private Time ThoiGianDongCua;
    private String TenNganHang;
    private String SoTaiKhoan;

    public String getMaChiNhanh() {
        return MaChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        MaChiNhanh = maChiNhanh;
    }

    public String getMaDoiTac() {
        return MaDoiTac;
    }

    public void setMaDoiTac(String maDoiTac) {
        MaDoiTac = maDoiTac;
    }

    public String getTenChiNhanh() {
        return TenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        TenChiNhanh = tenChiNhanh;
    }

    public String getDCChiNhanh() {
        return DCChiNhanh;
    }

    public void setDCChiNhanh(String DCChiNhanh) {
        this.DCChiNhanh = DCChiNhanh;
    }

    public String getTinhTrangHoatDong() {
        return TinhTrangHoatDong;
    }

    public void setTinhTrangHoatDong(String tinhTrangHoatDong) {
        TinhTrangHoatDong = tinhTrangHoatDong;
    }

    public Time getThoiGianMoCua() {
        return ThoiGianMoCua;
    }

    public void setThoiGianMoCua(Time thoiGianMoCua) {
        ThoiGianMoCua = thoiGianMoCua;
    }

    public double getDoanhThuThang() {
        return DoanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        DoanhThuThang = doanhThuThang;
    }

    public Time getThoiGianDongCua() {
        return ThoiGianDongCua;
    }

    public void setThoiGianDongCua(Time thoiGianDongCua) {
        ThoiGianDongCua = thoiGianDongCua;
    }

    public String getTenNganHang() {
        return TenNganHang;
    }

    public void setTenNganHang(String tenNganHang) {
        TenNganHang = tenNganHang;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        SoTaiKhoan = soTaiKhoan;
    }

    @Override
    public String toString() {
        return "ChiNhanhModel{" +
                "MaChiNhanh='" + MaChiNhanh + '\'' +
                ", MaDoiTac='" + MaDoiTac + '\'' +
                ", TenChiNhanh='" + TenChiNhanh + '\'' +
                ", DCChiNhanh='" + DCChiNhanh + '\'' +
                ", TinhTrangHoatDong='" + TinhTrangHoatDong + '\'' +
                ", ThoiGianMoCua=" + ThoiGianMoCua +
                ", DoanhThuThang=" + DoanhThuThang +
                ", ThoiGianDongCua=" + ThoiGianDongCua +
                ", TenNganHang='" + TenNganHang + '\'' +
                ", SoTaiKhoan='" + SoTaiKhoan + '\'' +
                '}';
    }

    public ChiNhanhModel(String maChiNhanh, String maDoiTac, String tenChiNhanh, String DCChiNhanh, String tinhTrangHoatDong, Time thoiGianMoCua, double doanhThuThang, Time thoiGianDongCua, String tenNganHang, String soTaiKhoan) {
        MaChiNhanh = maChiNhanh;
        MaDoiTac = maDoiTac;
        TenChiNhanh = tenChiNhanh;
        this.DCChiNhanh = DCChiNhanh;
        TinhTrangHoatDong = tinhTrangHoatDong;
        ThoiGianMoCua = thoiGianMoCua;
        DoanhThuThang = doanhThuThang;
        ThoiGianDongCua = thoiGianDongCua;
        TenNganHang = tenNganHang;
        SoTaiKhoan = soTaiKhoan;
    }

    public ChiNhanhModel() {
    }
}
