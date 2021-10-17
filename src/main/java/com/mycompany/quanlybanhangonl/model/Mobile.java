
package com.mycompany.quanlybanhangonl.model;
public class Mobile extends SanPham {
     // Attributes
    private String RAM;
    // Constructor
    public Mobile(){};
    public Mobile(String MaSP,String TenSP, String Hang, int SoLuong, int TinhTrang, float GiaGoc,  byte[] Anh, String RAM){
        super(MaSP, TenSP, Hang, SoLuong, TinhTrang, GiaGoc, Anh);
        this.RAM = RAM;
    }
    // Set - Get
    public void setRAM(String RAM) {
        this.RAM = RAM;
    }
    public String getRAM() {
        return RAM;
    }
        // Method
    // Ham tinh tien
    public float tinhThue(){
        float thue;
        if(getSoLuong() < 10){
            thue = (float)0.2;
        }
        else{
            thue = (float)0.15;
        }
        return thue;
    }
    public float tinhGTGT(){
        float gtgt;
        if(getTinhTrang() == 0){
            gtgt = (float)0.1;
        }
        else{
            gtgt = 0;
        }
        return gtgt;
    }
    @Override
    public float TinhTongTien(){
        float TongTien;
        TongTien = (float)( getGiaGoc()+(getGiaGoc()*tinhThue())+(getGiaGoc()*tinhGTGT()));
        return TongTien;
    }
}

