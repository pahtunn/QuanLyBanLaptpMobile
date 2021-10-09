
package com.mycompany.quanlybanhangonl.dao;

import com.mycompany.quanlybanhangonl.helpers.DatabaseHelper;
import com.mycompany.quanlybanhangonl.model.NguoiDung;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;



public class NguoiDungDao {
    public NguoiDung checkLogin(String TenDangNhap, String MatKhau)
       throws Exception{
        String sql = "SELECT TenDangNhap, MatKhau from NguoiDung "
                +" WHERE TenDangNhap=? and MatKhau=?"; 
        try(
             Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ){
          pstmt.setString(1, TenDangNhap);
          pstmt.setString(2, MatKhau);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(TenDangNhap);                   
                    return nd;
                }
            }
         }
    
        return null;
     
    }
}
