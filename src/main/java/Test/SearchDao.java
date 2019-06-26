package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtilForLocal;

public class SearchDao {
    public static void main(String[] args) {
        //注册的用户信息写入数据库
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select DISTINCT(name) from test where time='12345678' ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String keyword = new String();
                keyword = resultSet.getString("name");
                System.out.println(keyword.length());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtilForLocal.close(connection);
            DBUtilForLocal.close(preparedStatement);
        }
    }
}
