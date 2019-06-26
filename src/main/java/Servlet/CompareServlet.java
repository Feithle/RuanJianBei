package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Bean.AnalyzeResultBean;
import Bean.UserBean;
import DaoForLocalDataBase.InsertUserMassage;
import Encode.StrBinaryTurn;
import Extract.WaterMarkExtracterInternet;
import MacUtil.GetMac;
import Sort.GetId_ModinrowsForInternet;
import Sort.SortTheRowInBase;

/**
 * Servlet implementation class CompareServlet
 */
@WebServlet("/CompareServlet")
public class CompareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompareServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String key=request.getParameter("key");
		//String str_length=request.getParameter("length");
		//int length=Integer.parseInt(str_length);
	 	System.out.println(key);
	 	//System.out.println(length);
		System.out.println("extracting ......");
		UserBean userBean =new UserBean();
    	userBean.setKey(key);
    	userBean.setN(InsertUserMassage.getthecontent(key).length()*16);
    	WaterMarkExtracterInternet waterMarkExtracterInternet=new WaterMarkExtracterInternet();
    	GetId_ModinrowsForInternet getId_ModinrowsInternet=new GetId_ModinrowsForInternet();
    	SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
    	String code=StrBinaryTurn.test6(waterMarkExtracterInternet.extractWaterMark(sortTheRowInBase.SortAscend(getId_ModinrowsInternet.GetIdAndModOfEveryRows(userBean))));
    	AnalyzeResultBean analyzeResultBean=new AnalyzeResultBean();
    	GetMac getMac= new GetMac();//mac
    	analyzeResultBean.setMac(getMac.GetMac());
    	analyzeResultBean.setWatermarkcontent(code);//water mark
    	String result="result";//compare the result
    	if((InsertUserMassage.getthecontent(key).equals(code))&&(InsertUserMassage.getthemac(key).equals(analyzeResultBean.getMac()))) {
    		result="水印与mac对应，合法使用";
    	}
    	if((InsertUserMassage.getthecontent(key).equals(code))&&(!InsertUserMassage.getthemac(key).equals(analyzeResultBean.getMac()))) {
    		result="水印与mac不一致，非法使用";
    	}
    	if(!InsertUserMassage.getthecontent(key).equals(code)) {
    		result="水印不一致，无关";
    	}
    	analyzeResultBean.setResult(result);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(analyzeResultBean);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
		System.out.println("extract");
		
		}
}
