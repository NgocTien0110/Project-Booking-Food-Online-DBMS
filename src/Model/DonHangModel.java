package Model;

import java.util.Date;

public class DonHangModel {
    private String MaDonHang;
    private String TinhTrangDonHang;
    private double PhiDonHang;
    private String HinhThucThanhToan;
    private String DCGiaoHang;
    private float PhiVanChuyen;
    private Date NgayTaoDon;
    private String MaTaiKhoanTX;
    private String MaTaiKhoanKH;
    private String MaKhuVuc;

    public String getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        MaDonHang = maDonHang;
    }

    public String getTinhTrangDonHang() {
        return TinhTrangDonHang;
    }

    public void setTinhTrangDonHang(String tinhTrangDonHang) {
        TinhTrangDonHang = tinhTrangDonHang;
    }

    public double getPhiDonHang() {
        return PhiDonHang;
    }

    public void setPhiDonHang(double phiDonHang) {
        PhiDonHang = phiDonHang;
    }

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        HinhThucThanhToan = hinhThucThanhToan;
    }

    public String getDCGiaoHang() {
        return DCGiaoHang;
    }

    public void setDCGiaoHang(String DCGiaoHang) {
        this.DCGiaoHang = DCGiaoHang;
    }

    public float getPhiVanChuyen() {
        return PhiVanChuyen;
    }

    public void setPhiVanChuyen(float phiVanChuyen) {
        PhiVanChuyen = phiVanChuyen;
    }

    public Date getNgayTaoDon() {
        return NgayTaoDon;
    }

    public void setNgayTaoDon(Date ngayTaoDon) {
        NgayTaoDon = ngayTaoDon;
    }

    public String getMaTaiKhoanTX() {
        return MaTaiKhoanTX;
    }

    public void setMaTaiKhoanTX(String maTaiKhoanTX) {
        MaTaiKhoanTX = maTaiKhoanTX;
    }

    public String getMaTaiKhoanKH() {
        return MaTaiKhoanKH;
    }

    public void setMaTaiKhoanKH(String maTaiKhoanKH) {
        MaTaiKhoanKH = maTaiKhoanKH;
    }

    public String getMaKhuVuc() {
        return MaKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        MaKhuVuc = maKhuVuc;
    }

    @Override
    public String toString() {
        return "DonHangModel{" +
                "MaDonHang='" + MaDonHang + '\'' +
                ", TinhTrangDonHang='" + TinhTrangDonHang + '\'' +
                ", PhiDonHang=" + PhiDonHang +
                ", HinhThucThanhToan='" + HinhThucThanhToan + '\'' +
                ", DCGiaoHang='" + DCGiaoHang + '\'' +
                ", PhiVanChuyen=" + PhiVanChuyen +
                ", NgayTaoDon=" + NgayTaoDon +
                ", MaTaiKhoanTX='" + MaTaiKhoanTX + '\'' +
                ", MaTaiKhoanKH='" + MaTaiKhoanKH + '\'' +
                ", MaKhuVuc='" + MaKhuVuc + '\'' +
                '}';
    }

    public DonHangModel(String maDonHang, String tinhTrangDonHang, double phiDonHang, String hinhThucThanhToan, String DCGiaoHang, float phiVanChuyen, Date ngayTaoDon, String maTaiKhoanTX, String maTaiKhoanKH, String maKhuVuc) {
        MaDonHang = maDonHang;
        TinhTrangDonHang = tinhTrangDonHang;
        PhiDonHang = phiDonHang;
        HinhThucThanhToan = hinhThucThanhToan;
        this.DCGiaoHang = DCGiaoHang;
        PhiVanChuyen = phiVanChuyen;
        NgayTaoDon = ngayTaoDon;
        MaTaiKhoanTX = maTaiKhoanTX;
        MaTaiKhoanKH = maTaiKhoanKH;
        MaKhuVuc = maKhuVuc;
    }

    public DonHangModel() {
    }
}
