package com.tondz.apiretrofit;

public class TaiKhoan {
    private String TenTK,MatKhau,Role;

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String tenTK) {
        TenTK = tenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public TaiKhoan(String tenTK, String matKhau, String role) {
        TenTK = tenTK;
        MatKhau = matKhau;
        Role = role;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "TenTK='" + TenTK + '\'' +
                ", MatKhau='" + MatKhau + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
