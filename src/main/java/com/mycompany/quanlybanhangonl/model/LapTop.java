
package com.mycompany.quanlybanhangonl.model;
public class LapTop extends SanPham {
    // Attributes
    private String CPU;
    // Constructor
    public LapTop(){};
    public LapTop(String MaSP,String TenSP, String Hang, 
            int SoLuong, int TinhTrang, float GiaGoc, byte[] Anh, String CPU){
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
    @Override
    public float TinhTongTien(){
        float TongTien;
        TongTien = (float)((getGiaGoc() + (getGiaGoc()*0.2)));
        return TongTien;
    }
}

 