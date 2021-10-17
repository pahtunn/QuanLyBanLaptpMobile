
package com.mycompany.quanlybanhangonl.dao;

import com.mycompany.quanlybanhangonl.helpers.DatabaseHelper;
import com.mycompany.quanlybanhangonl.model.LapTop;
import com.mycompany.quanlybanhangonl.model.Mobile;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.ResumbSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

public class MobileDao {
    public boolean insert(Mobile mb)
       throws Exception{
        String sql = "INSERT INTO [dbo].[Mobile]([MaSP],[TenSP],[Hang],[RAM],[SoLuong],[GiaGoc],[TinhTrang],[GiaBan],[Anh])"
                +" values(?,?,?,?,?,?,?,?,?)";      
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, mb.getMaSP());
          pstmt.setString(2, mb.getTenSP());
          pstmt.setString(3, mb.getHang());
          pstmt.setString(4, mb.getRAM());
          pstmt.setInt(5, mb.getSoLuong());
          pstmt.setFloat(6, mb.getGiaGoc());
          pstmt.setInt(7, mb.getTinhTrang());
//          pstmt.setFloat(8, mb.getGiaBan()); 
         // File input = null;
        //  BufferedImage read = ImageIO.read(input);

          if(mb.getAnh() != null){
            Blob anh = new SerialBlob(mb.getAnh());
            pstmt.setBlob(9, anh);
            }else {
                 Blob anh = null;
                 pstmt.setBlob(9, anh);
            }
          return pstmt.executeUpdate()>0;
        } 
    }
    
    public boolean update(Mobile mb)
       throws Exception{
        String sql = "UPDATE [dbo].[Mobile]\n"
                + " SET [TenSP]=?,[Hang]=?,[RAM]=?,[SoLuong]=?,[GiaGoc]=?,[TinhTrang]=?,[GiaBan]=?,[Anh]=?"
                +" WHERE [MaSP]=?";      
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(9, mb.getMaSP());
          pstmt.setString(1, mb.getTenSP());
          pstmt.setString(2, mb.getHang());
          pstmt.setString(3, mb.getRAM());
          pstmt.setInt(4, mb.getSoLuong());
          pstmt.setFloat(5, mb.getGiaGoc());
          pstmt.setInt(6, mb.getTinhTrang());
//          pstmt.setFloat(7, mb.getGiaBan());
          if(mb.getAnh() != null){
            Blob anh = new SerialBlob(mb.getAnh());
            pstmt.setBlob(8, anh);
            }else {
                 Blob anh = null;
                 pstmt.setBlob(8, anh);
            }
          return pstmt.executeUpdate()>0;
        }
            
    }
    
    public boolean delete(Mobile mb)
       throws Exception{
        String sql = "DELETE FROM MOBILE\n"
                +" WHERE [MaSP]=?";      
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, mb.getMaSP());
          
          return pstmt.executeUpdate()>0;
        }
            
    }
    
    public Mobile findByID(String mMaSP)
       throws Exception{
        String sql = "SELECT * FROM MOBILE WHERE MASP =?";
                    
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, mMaSP);
          try(ResultSet rs = pstmt.executeQuery();){
              if(rs.next()){
                  Mobile mb = createMobile(rs);
                  return mb;
              }
          }
          return null;
        }
            
    }

    private Mobile createMobile(final ResultSet rs) throws SQLException {
        Mobile mb = new Mobile();
        mb.setMaSP(rs.getString("MaSP"));
        mb.setTenSP(rs.getString("TenSP"));
        mb.setHang(rs.getString("Hang"));
        mb.setRAM(rs.getString("RAM"));
        mb.setSoLuong(rs.getInt("SoLuong"));
        mb.setGiaGoc(rs.getFloat("GiaGoc"));
        mb.setTinhTrang(rs.getInt("TinhTrang"));
        Blob blob = rs.getBlob("Anh");
          if(blob != null){
        mb.setAnh(blob.getBytes(1, (int) blob.length()));}
        return mb;
    }
    
    public List< Mobile> findAll() throws Exception{
        String sql = "SELECT * FROM MOBILE";
                    
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          
          try(ResultSet rs = pstmt.executeQuery();){
              List<Mobile> list = new ArrayList<>(); 
              while(rs.next()){
                  Mobile mb = createMobile(rs);
                  list.add(mb);
              }
              return list;
          }
         
        }
            
    }
    
}
