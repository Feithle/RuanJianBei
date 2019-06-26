package DaoForLocalDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Bean.UserBean;
import DBUtil.DBUtilForLocal;

public class InsertUserMassage {
	public static void UserMassageInsert(String key,String content,String comment) {
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        try {
            String sql = "insert usermassage values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, comment);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtilForLocal.close(connection);
            DBUtilForLocal.close(preparedStatement);
        }
	}
	public static String getthecontent(String key) {
		//插入用户密钥与水印内容和时间

        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String content="";
        try {
            String sql = "select content from usermassage where userkey=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key);
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
				content=resultSet.getString("content");
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	DBUtilForLocal.close(resultSet);
            DBUtilForLocal.close(connection);
            DBUtilForLocal.close(preparedStatement);
        }
		return content;
	}
	public static String getthemac(String key) {
		//

        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String time_comment="";
        try {
            String sql = "select time_comment from usermassage where userkey=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key);
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            	time_comment=resultSet.getString("time_comment");
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	DBUtilForLocal.close(resultSet);
            DBUtilForLocal.close(connection);
            DBUtilForLocal.close(preparedStatement);
        }
		return time_comment;
	}
	
}
