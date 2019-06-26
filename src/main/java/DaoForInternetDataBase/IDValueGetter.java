package DaoForInternetDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtilForLocal;


/**
 * @author Cheyanlie
 * 2019年6月9日
 */
public class IDValueGetter {
	/**
	 * 
	 * @param i
	 * @return 
	 */
	public static String GetId(int i) {
		String ID="";//id
		int rownumber=i-1;//row start from zero
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
        	
            String sql = "SELECT id FROM ruanjianbeitestdata limit ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rownumber);
            preparedStatement.setInt(2, 1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	ID=resultSet.getString("id");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	if(resultSet!=null) {
        		DBUtilForLocal.close(resultSet);
        	}
            DBUtilForLocal.close(connection);
            DBUtilForLocal.close(preparedStatement);
        }
        return ID;
	}
	   public static void main(String[] args) {
		   	int times=CountRowsDao.GetTheRowsOfTheTable();
       		for(int i=1;i<=times;i++) {
       			System.out.println(i);
       			if(i>times) {
       				break;
       			}
       			int before=Integer.parseInt(IDValueGetter.GetId(i));
       			int after=Integer.parseInt(IDValueGetter.GetId(i+1));
       			if(before!=after-1){
       				System.out.println(IDValueGetter.GetId(i)+" "+IDValueGetter.GetId(i+1));
       			}
       		}
       }
}
