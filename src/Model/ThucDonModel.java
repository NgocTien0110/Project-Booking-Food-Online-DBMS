package Model;

public class ThucDonModel {
    private String MaChiNhanh;
    private String MaDoiTac;
    private String MaMonAn;
    private String TinhTrangMonAn;
    private float Gia;
    private int SLMonAn;
    private float TrungBinhSLSao;
    private int TongSLLike;
    private int TongSLDislike;

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

    public String getTinhTrangMonAn() {
        return TinhTrangMonAn;
    }

    public void setTinhTrangMonAn(String tinhTrangMonAn) {
        TinhTrangMonAn = tinhTrangMonAn;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float gia) {
        Gia = gia;
    }

    public int getSLMonAn() {
        return SLMonAn;
    }

    public void setSLMonAn(int SLMonAn) {
        this.SLMonAn = SLMonAn;
    }

    public float getTrungBinhSLSao() {
        return TrungBinhSLSao;
    }

    public void setTrungBinhSLSao(float trungBinhSLSao) {
        TrungBinhSLSao = trungBinhSLSao;
    }

    public int getTongSLLike() {
        return TongSLLike;
    }

    public void setTongSLLike(int tongSLLike) {
        TongSLLike = tongSLLike;
    }

    public int getTongSLDislike() {
        return TongSLDislike;
    }

    public void setTongSLDislike(int tongSLDislike) {
        TongSLDislike = tongSLDislike;
    }

    @Override
    public String toString() {
        return "ThucDonModel{" +
                "MaChiNhanh='" + MaChiNhanh + '\'' +
                ", MaDoiTac='" + MaDoiTac + '\'' +
                ", MaMonAn='" + MaMonAn + '\'' +
                ", TinhTrangMonAn='" + TinhTrangMonAn + '\'' +
                ", Gia=" + Gia +
                ", SLMonAn=" + SLMonAn +
                ", TrungBinhSLSao=" + TrungBinhSLSao +
                ", TongSLLike=" + TongSLLike +
                ", TongSLDislike=" + TongSLDislike +
                '}';
    }

    public ThucDonModel(String maChiNhanh, String maDoiTac, String maMonAn, String tinhTrangMonAn, float gia, int SLMonAn, float trungBinhSLSao, int tongSLLike, int tongSLDislike) {
        MaChiNhanh = maChiNhanh;
        MaDoiTac = maDoiTac;
        MaMonAn = maMonAn;
        TinhTrangMonAn = tinhTrangMonAn;
        Gia = gia;
        this.SLMonAn = SLMonAn;
        TrungBinhSLSao = trungBinhSLSao;
        TongSLLike = tongSLLike;
        TongSLDislike = tongSLDislike;
    }

    public ThucDonModel() {
    }
}
