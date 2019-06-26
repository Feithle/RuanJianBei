package DaoForLocalDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.DataBean;
import DBUtil.DBUtilForLocal;

public class GetAllTheData {
	public static ArrayList<DataBean> AllDataGetter(){
        Connection connection = DBUtilForLocal.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DataBean> dataBeans=new ArrayList<DataBean>();
        try {
            String sql = "SELECT * FROM ruanjianbeitestdata";
            //System.out.println("id:" +id);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               DataBean dataBean =new DataBean();
               dataBean.setId(resultSet.getString("id"));
               dataBean.setContent(resultSet.getString("content"));
               dataBeans.add(dataBean);
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
		return dataBeans;
	}
}
