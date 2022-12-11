package Model;

public class TaiKhoanModel {
    private String MaTaiKhoan;
    private String TenTaiKhoan;
    private String HoVaTen;
    private String SoDienThoai;
    private String DCTaiKhoan;
    private String Email;

    public String getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        MaTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan = tenTaiKhoan;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        HoVaTen = hoVaTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getDCTaiKhoan() {
        return DCTaiKhoan;
    }

    public void setDCTaiKhoan(String DCTaiKhoan) {
        this.DCTaiKhoan = DCTaiKhoan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "TaiKhoanModel{" +
                "MaTaiKhoan='" + MaTaiKhoan + '\'' +
                ", TenTaiKhoan='" + TenTaiKhoan + '\'' +
                ", HoVaTen='" + HoVaTen + '\'' +
                ", SoDienThoai='" + SoDienThoai + '\'' +
                ", DCTaiKhoan='" + DCTaiKhoan + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public TaiKhoanModel(String maTaiKhoan, String tenTaiKhoan, String hoVaTen, String soDienThoai, String DCTaiKhoan, String email) {
        MaTaiKhoan = maTaiKhoan;
        TenTaiKhoan = tenTaiKhoan;
        HoVaTen = hoVaTen;
        SoDienThoai = soDienThoai;
        this.DCTaiKhoan = DCTaiKhoan;
        Email = email;
    }

    public TaiKhoanModel() {
    }
}
