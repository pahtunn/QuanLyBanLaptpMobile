
package com.mycompany.quanlybanhangonl.model;

public abstract class SanPham {
     // Attributes
    private String MaSP;
    private String TenSP;
    private String Hang;
    private int SoLuong;
    private int TinhTrang;
    private float GiaGoc;
    private float GiaBan;
    private byte[] Anh;

    
    // Constructor
    public SanPham(){};
    public SanPham(String MaSP,String TenSP, String Hang, 
            int SoLuong, int TinhTrang, float GiaGoc, float GiaBan, byte[] Anh) {    
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Hang = Hang;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
        this.GiaGoc = GiaGoc;
        this.GiaBan = GiaBan;
        this.Anh = Anh;
    }
    // Set - Get
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getHang() {
        return Hang;
    }
    public void setHang(String Hang) {
        this.Hang = Hang;
    }
    public int getTinhTrang() {
        return TinhTrang;
    }
    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    public float getGiaGoc() {
        return GiaGoc;
    }
    public void setGiaGoc(float GiaGoc) {
        this.GiaGoc = GiaGoc;
    }
    public float getGiaBan() {
        return GiaBan;
    }
    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }
    public byte[] getAnh() {
        return Anh;
    }
    public void setAnh(byte[] Anh) {
        this.Anh = Anh;
    }
    // Phuong thuc truu tuong
    public abstract float TinhTongTien();
}
