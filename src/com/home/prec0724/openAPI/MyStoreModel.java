package com.home.prec0724.openAPI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

//JTAble에게 정보를 제공하는 컨트롤러 클래스
public class MyStoreModel extends AbstractTableModel{
	OpenDAO openDAO;
	List<Store> list;
	
	public MyStoreModel() {
		openDAO=new OpenDAO();
		list=openDAO.selectAll();
	
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Store store=list.get(row);
		String value="";
		
		switch(col) {
		case 0 : value=Double.toString(store.getLati());break;
		case 1 : value=Double.toString(store.getLongi());break;
		case 2 : value=store.getAddr();break;
		case 3 : value=store.getName();break;
		case 4 : value=store.getType();break;
		case 5 : value=store.getPhone();break;
		case 6 : value=store.getMain();break;
		
		}
		return value;
	}

}
