package Model;

public class MonAnModel {
    private String MaMonAn;
    private String TenMonAn;
    private String MieuTa;

    public String getMaMonAn() {
        return MaMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        MaMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        TenMonAn = tenMonAn;
    }

    public String getMieuTa() {
        return MieuTa;
    }

    public void setMieuTa(String mieuTa) {
        MieuTa = mieuTa;
    }

    @Override
    public String toString() {
        return "MonAnModel{" +
                "MaMonAn='" + MaMonAn + '\'' +
                ", TenMonAn='" + TenMonAn + '\'' +
                ", MieuTa='" + MieuTa + '\'' +
                '}';
    }

    public MonAnModel(String maMonAn, String tenMonAn, String mieuTa) {
        MaMonAn = maMonAn;
        TenMonAn = tenMonAn;
        MieuTa = mieuTa;
    }

    public MonAnModel() {
    }
}
