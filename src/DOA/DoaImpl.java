package DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import Model.Product;

public class DoaImpl implements ProductRepo{
	PreparedStatement stmp = null;  
    static Connection con = null;
    private static  DoaImpl doaImpl;
    private DoaImpl() {}
	public static DoaImpl getInstance(){
		if(doaImpl==null) {
			doaImpl = new DoaImpl();
			try {
//				String createCommand = "Create table app.product (productID int, productName varchar(20),catgory varchar(20),price float,quantity int,rol int)";
				System.out.println("trying to connect to db");
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		        con = DriverManager.getConnection("jdbc:derby:hsbcdb;create=true");
//		        Statement stm = con.createStatement();
//		        stm.execute(createCommand);
		        System.out.println("db connection completed");
		        return doaImpl;
			}catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return null;
		}
		else {
			return doaImpl;
		}
		
	}
	
	@Override
	public int add(Product p) {
		/*
		 * private int productID;
	private String productName;
	private String category;
	private float price;
	private int quantity;
	private int rol;
		 */
		String insertStr= "Insert into app.product values(?,?,?,?,?,?)";
		try {
			stmp = con.prepareStatement(insertStr);
			stmp.setInt(1, p.getProductID());
			stmp.setString(2, p.getProductName());
			stmp.setString(3, p.getCategory());
			stmp.setFloat(4, p.getPrice());
			stmp.setInt(5, p.getQuantity());
			stmp.setInt(6, p.getRol());
			int i = stmp.executeUpdate();
			if(i>0) {
				System.out.println("inserted");	
				return i;
			}
		}catch(SQLException ex) {
			System.out.println("error in adding data to database ");
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int pid) {
		String deleteStm = "delete from app.product where productID="+pid;
		try {
			stmp = con.prepareStatement(deleteStm);
            int i = stmp.executeUpdate();
            if(i>0) {
            	System.out.println("Deleted");
            	return i;
            }
		}catch(SQLException ex) {
			System.out.println("error in adding data to database ");
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Product p) {
		/*
		 * private int productID;
	private String productName;
	private String category;
	private float price;
	private int quantity;
	private int rol;
		 * */
		String updateStr = "update app.product set productName = ? ,category = ? ,price = ? ,quantity = ? ,rol = ?  where productID = ?";
		try {
			stmp = con.prepareStatement(updateStr);
			stmp.setString(1,p.getProductName());
            stmp.setString(2,p.getCategory());
            stmp.setFloat(3,p.getPrice());
            stmp.setInt(4, p.getQuantity());
            stmp.setInt(5, p.getRol());
            stmp.setInt(6, p.getProductID());
            int i = stmp.executeUpdate();
            if(i>0) {
            	System.out.println("Updated");
            	return i;
            }
		}catch(SQLException ex) {
			System.out.println("error in adding data to database ");
			ex.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public List showAll() {
		RowSetFactory factory;
        CachedRowSet crs = null;
        ArrayList<Product> list = new ArrayList() ;
        try {
            factory = RowSetProvider.newFactory();
            crs = factory.createCachedRowSet();
            crs.setUrl("jdbc:derby:hsbcdb");
            crs.setCommand("Select * from app.product	");
            crs.execute();
            while(crs.next()){
                list.add(new Product(crs.getInt(1),crs.getString(2),crs.getString(3),crs.getFloat(4),crs.getInt(5),crs.getInt(6)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                crs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		return null;
	}

}
