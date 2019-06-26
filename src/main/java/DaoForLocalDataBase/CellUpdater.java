package DaoForLocalDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtilForLocal;

/**
 * @author Cheyanlie
 *
 * 2019年5月18日
 */
public class CellUpdater {
	public void updateCell(int id,String attributename,String ChangedStr ) {
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update ruanjianbeitestdata set content='"+ChangedStr+"' where id='"+id+"'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtilForLocal.close(connection);
            DBUtilForLocal.close(preparedStatement);
        }
	}
	}
