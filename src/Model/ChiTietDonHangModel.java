package Model;

public class ChiTietDonHangModel {
    private String MaDonHang;
    private String MaChiNhanh;
    private String MaDoiTac;
    private String MaMonAn;
    private int SLMon;
    private String TuyChon;

    public String getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        MaDonHang = maDonHang;
    }

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

    public String getMaMonAn() {
        return MaMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        MaMonAn = maMonAn;
    }

    public int getSLMon() {
        return SLMon;
    }

    public void setSLMon(int SLMon) {
        this.SLMon = SLMon;
    }

    public String getTuyChon() {
        return TuyChon;
    }

    public void setTuyChon(String tuyChon) {
        TuyChon = tuyChon;
    }

    @Override
    public String toString() {
        return "ChiTietDonHang{" +
                "MaDonHang='" + MaDonHang + '\'' +
                ", MaChiNhanh='" + MaChiNhanh + '\'' +
                ", MaDoiTac='" + MaDoiTac + '\'' +
                ", MaMonAn='" + MaMonAn + '\'' +
                ", SLMon=" + SLMon +
                ", TuyChon='" + TuyChon + '\'' +
                '}';
    }

    public ChiTietDonHangModel(String maDonHang, String maChiNhanh, String maDoiTac, String maMonAn, int SLMon, String tuyChon) {
        MaDonHang = maDonHang;
        MaChiNhanh = maChiNhanh;
        MaDoiTac = maDoiTac;
        MaMonAn = maMonAn;
        this.SLMon = SLMon;
        TuyChon = tuyChon;
    }

    public ChiTietDonHangModel() {
    }
}
