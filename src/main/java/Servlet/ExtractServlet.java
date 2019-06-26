package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Bean.ResultBean;
import Bean.UserBean;
import DaoForLocalDataBase.InsertUserMassage;
import Encode.StrBinaryTurn;
import Extract.WaterMarkExtracter;
import Sort.GetId_Modinrows;
import Sort.SortTheRowInBase;

/**
 * Servlet implementation class ExtractServlet
 */
@WebServlet("/ExtractServlet")
public class ExtractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String key=request.getParameter("key");
	 	System.out.println(key);
		System.out.println("extracting ......");
		UserBean userBean =new UserBean();
    	userBean.setKey(key);
    	userBean.setN(InsertUserMassage.getthecontent(key).length()*16);
    	WaterMarkExtracter waterMarkExtracter=new WaterMarkExtracter();
    	GetId_Modinrows getId_Modinrows=new GetId_Modinrows();
    	SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
    	String code=StrBinaryTurn.test6(waterMarkExtracter.extractWaterMark(sortTheRowInBase.SortAscend(getId_Modinrows.GetIdAndModOfEveryRows(userBean))));
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(code);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
		System.out.println("extracted successfully");
	}

}
