package dataservice;

import java.util.ArrayList;

public class HBaseColumn {
	String rowkey;
	String colFamily;
	ArrayList<String> cols;
	ArrayList<String> vals;
	
	public HBaseColumn(String rowkey, String colFamily){
		this.rowkey = rowkey;
		this.colFamily = colFamily;
		cols = new ArrayList<String>();
		vals = new ArrayList<String>();
	}
	
	public HBaseColumn(String rowkey, String colFamily, String col, String val){
		this.rowkey = rowkey;
		this.colFamily = colFamily;
		cols = new ArrayList<String>();
		vals = new ArrayList<String>();
		cols.add(col);
		vals.add(val);
	}

	
	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getColFamily() {
		return colFamily;
	}

	public void setColFamily(String colFamily) {
		this.colFamily = colFamily;
	}

	public ArrayList<String> getCols() {
		return cols;
	}

	public void setCols(ArrayList<String> cols) {
		this.cols = cols;
	}

	public ArrayList<String> getVals() {
		return vals;
	}

	public void setVals(ArrayList<String> vals) {
		this.vals = vals;
	}
	
	public void addColumn(String col, String val){
		cols.add(col);
		vals.add(val);
	}
	
	
	
}
