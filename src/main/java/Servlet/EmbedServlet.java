package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Bean.UserBean;
import DaoForLocalDataBase.InsertUserMassage;
import Embed.WaterMarkEmbeder;
import Encode.StrBinaryTurn;
import Sort.GetId_Modinrows;
import Sort.SortTheRowInBase;
/**
 * Servlet implementation class EmbedServlet
 */
@WebServlet("/EmbedServlet")
public class EmbedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmbedServlet() {
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
		String key=request.getParameter("key");//;
		String content=request.getParameter("content");//input mac
		String comment=request.getParameter("comment");
		String markcontent="";
		System.out.println("getted the user's message");
		markcontent=StrBinaryTurn.test4(content);//turn user's input to string
		System.out.println("code: "+markcontent);
	 	UserBean userBean =new UserBean();
    	userBean.setKey(key);
    	userBean.setMarkContent(markcontent);
    	System.out.println("the length of code： "+content.length());
    	userBean.setN(userBean.getMarkContent().length());
    	WaterMarkEmbeder waterMarkEmbeder =new WaterMarkEmbeder();
    	GetId_Modinrows getId_Modinrows=new GetId_Modinrows();
    	SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
    	String result="embeded successfully";
    		waterMarkEmbeder.embedWaterMark(sortTheRowInBase.SortAscend(getId_Modinrows.GetIdAndModOfEveryRows(userBean)), userBean.getMarkContent());
    	InsertUserMassage.UserMassageInsert(key,content,comment);//saveing the message
    	ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(result);//fade back
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}

}
