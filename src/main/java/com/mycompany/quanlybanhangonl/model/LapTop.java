
package com.mycompany.quanlybanhangonl.model;
public class LapTop extends SanPham {
    // Attributes
    private String CPU;
    // Constructor
    public LapTop(){};
    public LapTop(String MaSP,String TenSP, String Hang, int SoLuong, int TinhTrang, float GiaGoc, byte[] Anh, String CPU){
        super(MaSP, TenSP, Hang, SoLuong, TinhTrang, GiaGoc, Anh);
        this.CPU = CPU;
    }
    // Set -Get
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }
    public String getCPU() {
        return CPU;
    }

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

 