package dataservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;



public class HBaseDataService {
	public Configuration configuration;
	public Connection connection;
	public Admin admin;

	public HBaseDataService() {
		initRec();
	}

	public HBaseDataService(boolean autoconf) {
		if (autoconf) {
			initRec();
		}
	}

	// 初始化链接
	public void initRec() {
		// 默认读取classpath下的hbase-site.xml
		configuration = HBaseConfiguration.create();
		configuration.set("hbase.zookeeper.quorum",
				"");
		configuration.set("hbase.zookeeper.property.clientPort",
				"");
		configuration.set("zookeeper.znode.parent", "");
		try {
			connection = ConnectionFactory.createConnection(configuration);
			admin = connection.getAdmin();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initRealtime() {
		// 默认读取classpath下的hbase-site.xml
		configuration = HBaseConfiguration.create();
		configuration.set("hbase.zookeeper.quorum", "");
		configuration.set("hbase.zookeeper.property.clientPort", "");
		configuration.set("zookeeper.znode.parent", "");
		try {
			connection = ConnectionFactory.createConnection(configuration);
			admin = connection.getAdmin();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 关闭连接
	public void close() {
		try {
			if (null != admin) {
				admin.close();
			}
			if (null != connection) {
                connection.close();
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 建表
	public void createTable(String tableNmae, String[] cols, int hbaseTTL)
			throws IOException {

		TableName tableName = TableName.valueOf(tableNmae);

		if (admin.tableExists(tableName)) {
			System.out.println("talbe is exists!");
		} else {
			HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
			for (String col : cols) {
				HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(col);
				// set ttl
				hColumnDescriptor.setTimeToLive(hbaseTTL);
				// set max version
				hColumnDescriptor.setMaxVersions(1);
				hTableDescriptor.addFamily(hColumnDescriptor);
			}
			admin.createTable(hTableDescriptor);
		}
	}

	public void createTable(String tableNmae, String col, int hbaseTTL)
			throws IOException {

		TableName tableName = TableName.valueOf(tableNmae);

		if (admin.tableExists(tableName)) {
			System.out.println("talbe is exists!");
		} else {
			HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
			HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(col);
			// set ttl
			hColumnDescriptor.setTimeToLive(hbaseTTL);
			// set max version
			hColumnDescriptor.setMaxVersions(1);
			hTableDescriptor.addFamily(hColumnDescriptor);
			admin.createTable(hTableDescriptor);
		}
	}

	public void createTable(String tableNmae, String col, int hbaseTTL,
			int versionNum) throws IOException {

		TableName tableName = TableName.valueOf(tableNmae);

		if (admin.tableExists(tableName)) {
			System.out.println("talbe is exists!");
		} else {
			HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
			HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(col);
			// set ttl
			hColumnDescriptor.setTimeToLive(hbaseTTL);
			// set max version
			if (versionNum > 0) {
				hColumnDescriptor.setMaxVersions(versionNum);
			}
			hTableDescriptor.addFamily(hColumnDescriptor);
			admin.createTable(hTableDescriptor);
		}
	}

	// //删表
	// public void deleteTable(String tableName) throws IOException {
	// TableName tn = TableName.valueOf(tableName);
	// if (admin.tableExists(tn)) {
	// admin.disableTable(tn);
	// admin.deleteTable(tn);
	// }
	// }

	// 查看已有表
	public void listTables() throws IOException {
		HTableDescriptor hTableDescriptors[] = admin.listTables();
		for (HTableDescriptor hTableDescriptor : hTableDescriptors) {
			System.out.println(hTableDescriptor.getNameAsString());
		}
	}

	// 批量插入数据
	public void insertRow(String tableName, List<HBaseColumn> columns)
			throws IOException {
		Table table = connection.getTable(TableName.valueOf(tableName));
		List<Put> putList = new ArrayList<Put>();
		for (HBaseColumn column : columns) {
			Put put = new Put(Bytes.toBytes(column.getRowkey()));
			ArrayList<String> cols = column.getCols();
			ArrayList<String> vals = column.getVals();
			for (int i = 0; i < cols.size(); i++) {
				put.addColumn(Bytes.toBytes(column.getColFamily()),
						Bytes.toBytes(cols.get(i)), Bytes.toBytes(vals.get(i)));
				putList.add(put);
			}
		}
		table.put(putList);
		table.close();
	}

	// 删除数据
	public void deleRow(String tableName, String rowkey, String colFamily,
			String col) throws IOException {
		Table table = connection.getTable(TableName.valueOf(tableName));
		Delete delete = new Delete(Bytes.toBytes(rowkey));
		// 删除指定列族
		// delete.addFamily(Bytes.toBytes(colFamily));
		// 删除指定列
		// delete.addColumn(Bytes.toBytes(colFamily),Bytes.toBytes(col));
		table.delete(delete);
		// 批量删除
		/*
		 * List<Delete> deleteList = new ArrayList<Delete>();
		 * deleteList.add(delete); table.delete(deleteList);
		 */
		table.close();
	}

	// 根据rowkey查找数据
	public Result getData(String tableName, String rowkey) throws IOException {
		Table table = connection.getTable(TableName.valueOf(tableName));
		Get get = new Get(Bytes.toBytes(rowkey));
		Result result = table.get(get);

		// showCell(result);
		table.close();
		return result;
	}

	public Result getData(String tableName, String rowkey, String colFamily,
			String col) throws IOException {
		Table table = connection.getTable(TableName.valueOf(tableName));
		Get get = new Get(Bytes.toBytes(rowkey));
		// 获取指定列数据
		get.addColumn(Bytes.toBytes(colFamily), Bytes.toBytes(col));
		Result result = table.get(get);
		// showCell(result);
		table.close();
		return result;
	}

	// 格式化输出
	public void showCell(Result result) {
		Cell[] cells = result.rawCells();
		for (Cell cell : cells) {
			System.out.println("RowName:" + new String(CellUtil.cloneRow(cell))
					+ " ");
			System.out.println("Timetamp:" + cell.getTimestamp() + " ");
			System.out.println("column Family:"
					+ new String(CellUtil.cloneFamily(cell)) + " ");
			System.out.println("row Name:"
					+ new String(CellUtil.cloneQualifier(cell)) + " ");
			System.out.println("value:" + new String(CellUtil.cloneValue(cell))
					+ " ");
		}
	}

	// 批量查找数据
	public ResultScanner scanData(String tableName, String startRow,
			String stopRow) throws IOException {
		Table table = connection.getTable(TableName.valueOf(tableName));
		Scan scan = new Scan();
		if (startRow != null) {
			scan.setStartRow(Bytes.toBytes(startRow));
		}
		if (stopRow != null) {
			scan.setStopRow(Bytes.toBytes(stopRow));
		}
		ResultScanner resultScanner = table.getScanner(scan);
		table.close();

		return resultScanner;
	}

    public ResultScanner scaneByPrefixFilter(String tablename, String rowPrifix) {
        try {
            Table table = connection.getTable(TableName.valueOf(tablename));
            Scan s = new Scan();
            s.setFilter(new PrefixFilter(rowPrifix.getBytes()));
            ResultScanner rs = table.getScanner(s);
            //KeyValue[] kv = result.raw();
            //for (int i = 0; i < kv.length; i++) {
            //    System.out.print(new String(kv[i].getRow()) + "  ");
            //    System.out.print(new String(kv[i].getFamily()) + ":");
            //    System.out.print(new String(kv[i].getQualifier()) + "  ");
            //    System.out.print(kv[i].getTimestamp() + "  ");
            //    System.out.println(new String(kv[i].getValue()));
            //}
            return rs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



	public Result[] batchQuery(String tableName, List<String> rowkeyList,
			String column, String qualifier) {
		Table table = null;
		try {
			table = connection.getTable(TableName.valueOf(tableName));

			List<Get> getList = new ArrayList<Get>();
			for (String rowkey : rowkeyList) {
				Get get = new Get(Bytes.toBytes(rowkey));
				get.addColumn(Bytes.toBytes(column), Bytes.toBytes(qualifier));
				getList.add(get);
			}

			Result[] rst = table.get(getList);
			if (rst != null && rst.length > 0) {
				return rst;
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (table != null) {
					table.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Result[] batchQuery(String tableName, List<String> rowkeyList) {
		Table table = null;
		try {
			table = connection.getTable(TableName.valueOf(tableName));

			List<Get> getList = new ArrayList<Get>();
			for (String rowkey : rowkeyList) {
				Get get = new Get(Bytes.toBytes(rowkey));
				getList.add(get);
			}

			Result[] rst = table.get(getList);
			if (rst != null && rst.length > 0) {
				return rst;
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (table != null) {
					table.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
