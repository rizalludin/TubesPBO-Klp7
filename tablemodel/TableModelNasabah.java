/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joop.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import joop.entity.Nasabah;


public class TableModelNasabah extends AbstractTableModel {
    private ArrayList<Nasabah> listNasabah = new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return listNasabah.size();
    }
    
    @Override
    public int getColumnCount(){
        return 3;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0: return listNasabah.get(rowIndex).getKodenasabah();
            case 1: return listNasabah.get(rowIndex).getNama();
            case 2: return listNasabah.get(rowIndex).getAlamat();
            default: return null;
        }
    }
    
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode Nasabah";
            case 1: return "Nama";
            case 2: return "Alamat";
            default: return null;
        }
    }
    
    public void createNasabah(Nasabah n){
        listNasabah.add(n);
        fireTableDataChanged();
    }
    
    public void updateNasabah(int index, Nasabah n){
        listNasabah.set(index,n);
        fireTableDataChanged();
    }
    
    public void deleteNasabah(int index){
        listNasabah.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<Nasabah> listNasabah){
        this.listNasabah = listNasabah;
        fireTableDataChanged();
    }
    
    public Nasabah getNasabah(int index) {
        return listNasabah.get(index);
    }
    
    public void clear(){
        listNasabah.clear();
    }
}
