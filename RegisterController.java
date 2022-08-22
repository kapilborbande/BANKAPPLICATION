package Bank.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bank.Dao.RegisterDao;
import Bank.model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	

		int rno=Integer.parseInt(request.getParameter("rno"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");

		double accbal=Double.parseDouble(request.getParameter("accbal"));
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		System.out.println("register controllet -test1");
		Register regmodel=new Register(rno, fname, accbal, uname, pass);
		List<Register> lstreg=new ArrayList<Register>();

		RegisterDao regdao=new RegisterDao();
		lstreg.add(regmodel);

		System.out.println("register controllet -test2");		
		int i=regdao.create(lstreg);
		System.out.println("register controllet -test3");
		if(i>=0) 
		{
			response.sendRedirect("Login.html");
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
