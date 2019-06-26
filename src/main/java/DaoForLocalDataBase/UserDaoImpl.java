package DaoForLocalDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.DataBean;
import Bean.HtmlBean;

import java.util.ArrayList;
import DBUtil.*;
public class UserDaoImpl{
	@SuppressWarnings("resource")
	public static void add(HtmlBean htmlBean) {
		Connection connection = DBUtilForLocal.getConnection();
		String sql = "insert into paquruanjianbei values (?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, htmlBean.getId());
			preparedStatement.setString(2, htmlBean.getContent());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtilForLocal.close(preparedStatement);
			DBUtilForLocal.close(connection);
		}
	}
}
