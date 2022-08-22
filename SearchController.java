package Bank.Controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bank.Dao.RegisterDao;
import Bank.model.Register;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int rno=Integer.parseInt(request.getParameter("rno"));
	
	System.out.println("Controller pront");
	RegisterDao regdao=new RegisterDao();
	Register r=regdao.searchData(rno);
	//List<Register> lst=regdao.getAllData();
	
	System.out.println(r.getRno()+"\t"+r.getFname()+"\t"+r.getAccbal()+"\t"+r.getUname()+"\t"+r.getPass());
	//lst.add(r);	

	
	System.out.println("In Search Servlet r:"+r);
	
	
	if(r!=null)
	{
		HttpSession session=request.getSession();
		session.setAttribute("sdata",r);
		response.sendRedirect("Search.jsp");
	}
	else
	{
		response.sendRedirect("Error.html");
	}
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
