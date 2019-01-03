/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joop.service;

import java.sql.SQLException;
import java.util.ArrayList;
import joop.entity.Nasabah;

/**
 *
 * @author ThinkPad
 */
public interface ServiceNasabah {
    public void createNasabah(Nasabah n) throws SQLException;
    public void updateNasabah(Nasabah n) throws SQLException;
    public void deleteNasabah(Nasabah n) throws SQLException;
    public Nasabah getNasabahByKodenasabah(String kodenasabah) throws SQLException;
    public ArrayList<Nasabah> getNasabah() throws SQLException;
}
