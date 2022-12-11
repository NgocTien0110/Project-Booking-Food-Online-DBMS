package Model;

public class LoaiAmThucModel {
    private String TenLoaiAmThuc;
    private String MaDoiTac;

    public String getTenLoaiAmThuc() {
        return TenLoaiAmThuc;
    }

    public void setTenLoaiAmThuc(String tenLoaiAmThuc) {
        TenLoaiAmThuc = tenLoaiAmThuc;
    }

    public String getMaDoiTac() {
        return MaDoiTac;
    }

    public void setMaDoiTac(String maDoiTac) {
        MaDoiTac = maDoiTac;
    }

    @Override
    public String toString() {
        return "LoaiAmThucModel{" +
                "TenLoaiAmThuc='" + TenLoaiAmThuc + '\'' +
                ", MaDoiTac='" + MaDoiTac + '\'' +
                '}';
    }

    public LoaiAmThucModel(String tenLoaiAmThuc, String maDoiTac) {
        TenLoaiAmThuc = tenLoaiAmThuc;
        MaDoiTac = maDoiTac;
    }

    public LoaiAmThucModel() {
    }
}
