package Model;

import java.util.Date;

public class HopDongModel {
    private String MaHopDong;
    private Date NgayKi;
    private int ThoiGianHieuLuc;
    private float PhamTramHoaHong;
    private double PhiHoaHong;
    private String MaTaiKhoanDD;
    private String MaDoiTac;
    private String MaTaiKhoanNV;

    public String getMaHopDong() {
        return MaHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        MaHopDong = maHopDong;
    }

    public Date getNgayKi() {
        return NgayKi;
    }

    public void setNgayKi(Date ngayKi) {
        NgayKi = ngayKi;
    }

    public int getThoiGianHieuLuc() {
        return ThoiGianHieuLuc;
    }

    public void setThoiGianHieuLuc(int thoiGianHieuLuc) {
        ThoiGianHieuLuc = thoiGianHieuLuc;
    }

    public float getPhamTramHoaHong() {
        return PhamTramHoaHong;
    }

    public void setPhamTramHoaHong(float phamTramHoaHong) {
        PhamTramHoaHong = phamTramHoaHong;
    }

    public double getPhiHoaHong() {
        return PhiHoaHong;
    }

    public void setPhiHoaHong(double phiHoaHong) {
        PhiHoaHong = phiHoaHong;
    }

    public String getMaTaiKhoanDD() {
        return MaTaiKhoanDD;
    }

    public void setMaTaiKhoanDD(String maTaiKhoanDD) {
        MaTaiKhoanDD = maTaiKhoanDD;
    }

    public String getMaDoiTac() {
        return MaDoiTac;
    }

    public void setMaDoiTac(String maDoiTac) {
        MaDoiTac = maDoiTac;
    }

    public String getMaTaiKhoanNV() {
        return MaTaiKhoanNV;
    }

    public void setMaTaiKhoanNV(String maTaiKhoanNV) {
        MaTaiKhoanNV = maTaiKhoanNV;
    }

    @Override
    public String toString() {
        return "HopDongModel{" +
                "MaHopDong='" + MaHopDong + '\'' +
                ", NgayKi=" + NgayKi +
                ", ThoiGianHieuLuc=" + ThoiGianHieuLuc +
                ", PhamTramHoaHong=" + PhamTramHoaHong +
                ", PhiHoaHong=" + PhiHoaHong +
                ", MaTaiKhoanDD='" + MaTaiKhoanDD + '\'' +
                ", MaDoiTac='" + MaDoiTac + '\'' +
                ", MaTaiKhoanNV='" + MaTaiKhoanNV + '\'' +
                '}';
    }

    public HopDongModel(String maHopDong, Date ngayKi, int thoiGianHieuLuc, float phamTramHoaHong, double phiHoaHong, String maTaiKhoanDD, String maDoiTac, String maTaiKhoanNV) {
        MaHopDong = maHopDong;
        NgayKi = ngayKi;
        ThoiGianHieuLuc = thoiGianHieuLuc;
        PhamTramHoaHong = phamTramHoaHong;
        PhiHoaHong = phiHoaHong;
        MaTaiKhoanDD = maTaiKhoanDD;
        MaDoiTac = maDoiTac;
        MaTaiKhoanNV = maTaiKhoanNV;
    }

    public HopDongModel() {
    }
}
