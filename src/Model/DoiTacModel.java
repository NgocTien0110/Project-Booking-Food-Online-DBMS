package Model;

public class DoiTacModel {
    private String MaDoiTac;
    private String TenDoiTac;
    private int SLChiNhanh;
    private String DCDoiTac;
    private int SLDonMoiNgay;
    private String MaSoThue;
    private String EmailDT;
    private String SoDienThoaiDT;
    private double DoanhThuThang;

    public String getMaDoiTac() {
        return MaDoiTac;
    }

    public void setMaDoiTac(String maDoiTac) {
        MaDoiTac = maDoiTac;
    }

    public String getTenDoiTac() {
        return TenDoiTac;
    }

    public void setTenDoiTac(String tenDoiTac) {
        TenDoiTac = tenDoiTac;
    }

    public int getSLChiNhanh() {
        return SLChiNhanh;
    }

    public void setSLChiNhanh(int SLChiNhanh) {
        this.SLChiNhanh = SLChiNhanh;
    }

    public String getDCDoiTac() {
        return DCDoiTac;
    }

    public void setDCDoiTac(String DCDoiTac) {
        this.DCDoiTac = DCDoiTac;
    }

    public int getSLDonMoiNgay() {
        return SLDonMoiNgay;
    }

    public void setSLDonMoiNgay(int SLDonMoiNgay) {
        this.SLDonMoiNgay = SLDonMoiNgay;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        MaSoThue = maSoThue;
    }

    public String getEmailDT() {
        return EmailDT;
    }

    public void setEmailDT(String emailDT) {
        EmailDT = emailDT;
    }

    public String getSoDienThoaiDT() {
        return SoDienThoaiDT;
    }

    public void setSoDienThoaiDT(String soDienThoaiDT) {
        SoDienThoaiDT = soDienThoaiDT;
    }

    public double getDoanhThuThang() {
        return DoanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        DoanhThuThang = doanhThuThang;
    }

    @Override
    public String toString() {
        return "DoiTacModel{" +
                "MaDoiTac='" + MaDoiTac + '\'' +
                ", TenDoiTac='" + TenDoiTac + '\'' +
                ", SLChiNhanh=" + SLChiNhanh +
                ", DCDoiTac='" + DCDoiTac + '\'' +
                ", SLDonMoiNgay=" + SLDonMoiNgay +
                ", MaSoThue='" + MaSoThue + '\'' +
                ", EmailDT='" + EmailDT + '\'' +
                ", SoDienThoaiDT='" + SoDienThoaiDT + '\'' +
                ", DoanhThuThang=" + DoanhThuThang +
                '}';
    }

    public DoiTacModel(String maDoiTac, String tenDoiTac, int SLChiNhanh, String DCDoiTac, int SLDonMoiNgay, String maSoThue, String emailDT, String soDienThoaiDT, double doanhThuThang) {
        MaDoiTac = maDoiTac;
        TenDoiTac = tenDoiTac;
        this.SLChiNhanh = SLChiNhanh;
        this.DCDoiTac = DCDoiTac;
        this.SLDonMoiNgay = SLDonMoiNgay;
        MaSoThue = maSoThue;
        EmailDT = emailDT;
        SoDienThoaiDT = soDienThoaiDT;
        DoanhThuThang = doanhThuThang;
    }

    public DoiTacModel() {
    }
}
