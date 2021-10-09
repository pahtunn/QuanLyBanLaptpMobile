
package com.mycompany.quanlybanhangonl.model;


public class Mobile extends SanPham {
     // Attributes
    private String RAM;
    // Constructor
    public Mobile(){};
    public Mobile(String MaSP,String TenSP, String Hang, 
            int SoLuong, int TinhTrang, float GiaGoc, float GiaBan, byte[] Anh, String RAM){
        super(MaSP, TenSP, Hang, SoLuong, TinhTrang, GiaGoc, GiaBan, Anh);
        this.RAM = RAM;
    }
    // Set - Get

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }
    
    // Ham tinh tien
    @Override
    public float TinhTongTien(){
        float TongTien;
        TongTien = (float)((getGiaGoc() + (getGiaGoc()*0.2)));
        return TongTien;
    }
}

