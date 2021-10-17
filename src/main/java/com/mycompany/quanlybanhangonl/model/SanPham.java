
package com.mycompany.quanlybanhangonl.model;

public abstract class SanPham {
     // Attributes
    private String MaSP;
    private String TenSP;
    private String Hang;
    private int SoLuong;
    private int TinhTrang;
    private float GiaGoc;
    private byte[] Anh;

    // Constructor
    public SanPham(){};
    public SanPham(String MaSP,String TenSP, String Hang, int SoLuong, int TinhTrang, float GiaGoc,  byte[] Anh) {    
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Hang = Hang;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
        this.GiaGoc = GiaGoc;
        this.Anh = Anh;
    }
    // Set - Get
    public void setMaSP(String MaSP){
        this.MaSP = MaSP;
    }
    public String getMaSP() {
        return this.MaSP;
    }
    public void setTenSP(String TenSP){
        this.TenSP = TenSP;
    }
    public String getTenSP(){
        return this.TenSP;
    }
    public void setHang(String Hang){
        this.Hang = Hang;
    }
    public String getHang(){
        return this.Hang;
    }
    public void setSoLuong(int SoLuong){
        this.SoLuong = SoLuong;
    }
    public int getSoLuong(){
        return this.SoLuong;
    }
    public void setTinhTrang(int TinhTrang){
        this.TinhTrang = TinhTrang;
    }
    public int getTinhTrang(){
        return this.TinhTrang;
    }
    public void setGiaGoc(float GiaGoc){
        this.GiaGoc = GiaGoc;
    }
    public float getGiaGoc(){
        return this.GiaGoc;
    }
    public void setAnh(byte[] Anh) {
        this.Anh = Anh;
    }
    public byte[] getAnh() {
        return Anh;
    }

    // Phuong thuc truu tuong
    public abstract float TinhTongTien();
}
