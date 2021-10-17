/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhangonl.dao;

import com.mycompany.quanlybanhangonl.helpers.DatabaseHelper;
import com.mycompany.quanlybanhangonl.model.LapTop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import static javax.management.Query.lt;
import javax.sql.rowset.serial.SerialBlob;

public class LapTopDao {
    public boolean insert(LapTop lt)
       throws Exception{
        String sql = "INSERT INTO [dbo].[LapTop]([MaSP],[TenSP],[Hang],[CPU],[SoLuong],[GiaGoc],[TinhTrang],[GiaBan],[Anh])"
                +" values(?,?,?,?,?,?,?,?,?)";      
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, lt.getMaSP());
          pstmt.setString(2, lt.getTenSP());
          pstmt.setString(3, lt.getHang());
          pstmt.setString(4, lt.getCPU());
          pstmt.setInt(5, lt.getSoLuong());
          pstmt.setFloat(6, lt.getGiaGoc());
          pstmt.setInt(7, lt.getTinhTrang());
          // pstmt.setFloat(8, lt.getGiaBan());
         // File input = null;
        //  BufferedImage read = ImageIO.read(input);

          if(lt.getAnh() != null){
            Blob anh = new SerialBlob(lt.getAnh());
            pstmt.setBlob(9, anh);
            }else {
                 Blob anh = null;
                 pstmt.setBlob(9, anh);
            }
          return pstmt.executeUpdate()>0;
        }
            
    }
    
    public boolean update(LapTop lt)
       throws Exception{
        String sql = "UPDATE [dbo].[LapTop]\n"
                + " SET [TenSP]=?,[Hang]=?,[CPU]=?,[SoLuong]=?,[GiaGoc]=?,[TinhTrang]=?,[GiaBan]=?,[Anh]=?"
                +" WHERE [MaSP]=?";      
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(9, lt.getMaSP());
          pstmt.setString(1, lt.getTenSP());
          pstmt.setString(2, lt.getHang());
          pstmt.setString(3, lt.getCPU());
          pstmt.setInt(4, lt.getSoLuong());
          pstmt.setFloat(5, lt.getGiaGoc());
          pstmt.setInt(6, lt.getTinhTrang());
//          pstmt.setFloat(7, lt.getGiaBan());
          if(lt.getAnh() != null){
            Blob anh = new SerialBlob(lt.getAnh());
            pstmt.setBlob(8, anh);
            }else {
                 Blob anh = null;
                 pstmt.setBlob(8, anh);
            }
          return pstmt.executeUpdate()>0;
        }
            
    }
    
    public boolean delete(LapTop lt)
       throws Exception{
        String sql = "DELETE FROM LAPTOP\n"
                +" WHERE [MaSP]=?";      
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, lt.getMaSP());
          
          return pstmt.executeUpdate()>0;
        }
            
    }
    
    public LapTop findByID(String MaSP)
       throws Exception{
        String sql = "SELECT * FROM LAPTOP WHERE MASP =?";
                    
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, MaSP);
          try(ResultSet rs = pstmt.executeQuery();){
              if(rs.next()){
                  LapTop lt = createLapTop(rs);
                  return lt;
              }
          }
          return null;
        }
            
    }

    private LapTop createLapTop(final ResultSet rs) throws SQLException {
        LapTop lt = new LapTop();
        lt.setMaSP(rs.getString("MaSP"));
        lt.setTenSP(rs.getString("TenSP"));
        lt.setHang(rs.getString("Hang"));
        lt.setCPU(rs.getString("CPU"));
        lt.setSoLuong(rs.getInt("SoLuong"));
        lt.setGiaGoc(rs.getFloat("GiaGoc"));
        lt.setTinhTrang(rs.getInt("TinhTrang"));
        Blob blob = rs.getBlob("Anh");
          if(blob != null){
        lt.setAnh(blob.getBytes(1, (int) blob.length()));}
        return lt;
    }
    
    public List< LapTop> findAll() throws Exception{
        String sql = "SELECT * FROM LAPTOP";
                    
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          
          try(ResultSet rs = pstmt.executeQuery();){
              List<LapTop> list = new ArrayList<>(); 
              while(rs.next()){
                  LapTop lt = createLapTop(rs);
                  list.add(lt);
              }
              return list;
          }
         
        }
            
    }
}
