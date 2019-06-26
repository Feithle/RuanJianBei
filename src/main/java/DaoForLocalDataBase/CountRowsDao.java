package DaoForLocalDataBase;

import DBUtil.DBUtilForLocal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountRowsDao {
    public static int GetTheRowsOfTheTable() {
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0;
        try {
            String sql = "SELECT * FROM ruanjianbeitestdata";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rows = rows + 1;
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
        return rows;
    }
}
