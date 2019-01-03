/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import joop.config.Koneksi;
import joop.entity.Nasabah;
import joop.service.ServiceNasabah;

/**
 *
 * @author ThinkPad
 */
public class DaoNasabah implements ServiceNasabah{
    
    private Connection connection;
    
    public DaoNasabah() throws SQLException{
        connection = Koneksi.getConnection();
    }
    
    @Override
    public void createNasabah(Nasabah n) throws SQLException{
        PreparedStatement st = null;
        String sql = "INSERT INTO tablenasabah VALUE(?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, n.getKodenasabah());
            st.setString(2, n.getNama());
            st.setString(3, n.getAlamat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null){
                st.close();
            }
        }
    }
    
    @Override
    public void updateNasabah(Nasabah n) throws SQLException{
        PreparedStatement st = null;
        String sql = "UPDATE tablenasabah SET nama=?, alamat=? where kodenasabah=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, n.getNama());
            st.setString(2, n.getAlamat());
            st.setString(3, n.getKodenasabah());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
        if (st != null){
            st.close();
        }
    }
   }
    
    @Override
    public void deleteNasabah(Nasabah n) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM tablenasabah WHERE kodenasabah=?";
        
        try {
            st = connection.prepareCall(sql);
            st.setString(1, n.getKodenasabah());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
//    @Override
    public Nasabah getNasabahByKodenasabah(String kodenasabah) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Nasabah n = null;
        String sql = "SELECT * FROM tablenasabah WHERE kodenasabah=?";
        
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, kodenasabah);
            rs = st.executeQuery();
            while (rs.next()) {
                n = new Nasabah();
                n.setKodenasabah(rs.getString("kodenasabah"));
                n.setNama(rs.getString("nama"));
                n.setAlamat(rs.getString("alamat"));
            }
            return n;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null){
                st.close();
            }
            if (rs != null){
                rs.close();
            }
        }
    }
    
    @Override
    public ArrayList<Nasabah> getNasabah() throws SQLException {
        PreparedStatement st = null;
        ArrayList<Nasabah> listNasabah = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tablenasabah";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Nasabah n = new Nasabah();
                n.setKodenasabah(rs.getString("kodenasabah"));
                n.setNama(rs.getString("nama"));
                n.setAlamat(rs.getString("alamat"));
                listNasabah.add(n);
            }
            return listNasabah;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if (rs != null){
                rs.close();
            }
        }
    }
}
