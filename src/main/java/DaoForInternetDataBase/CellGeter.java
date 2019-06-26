package DaoForInternetDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtilForLocal;

/**
 * @author Cheyanlie
 * local the position of a cell
 */
public class CellGeter{
	/**
	 * @param id
	 * @param attributename
	 * @return the string will being insert a char
	 */
	public String GetCell(int id,String attributename) {
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String oriStr="";
        try {
            String sql = "SELECT * FROM ruanjianbeitestdata where id='"+id+"'";
            //System.out.println("id:" +id);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                oriStr=resultSet.getString(attributename);
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
		return oriStr;
	}
}
