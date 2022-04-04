package com.tondz.apiretrofit;

public class ThongTinTaiKhoan {
    private String TenTK,HoTen,GioiTinh,NgaySinh,DiaChi,Email,SDT;

    @Override
    public String toString() {
        return "ThongTinTaiKhoan{" +
                "TenTK='" + TenTK + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", NgaySinh='" + NgaySinh + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Email='" + Email + '\'' +
                ", SDT='" + SDT + '\'' +
                '}';
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String tenTK) {
        TenTK = tenTK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public ThongTinTaiKhoan(String tenTK, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String email, String SDT) {
        TenTK = tenTK;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Email = email;
        this.SDT = SDT;
    }
}
