package DaoForLocalDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtilForLocal;
public class CellGeter{
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
