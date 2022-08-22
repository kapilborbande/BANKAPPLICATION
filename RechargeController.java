package Bank.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bank.Dao.RechargeDao;
import Bank.model.Recharge;
import Bank.model.Register;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String mobno=request.getParameter("mobno");
		double rechargeamt=Double.parseDouble(request.getParameter("rechargeamt"));
		String servicep=request.getParameter("servicep");
	
		HttpSession session=request.getSession();
		
		List<Register> lstreg=(List<Register>) session.getAttribute("cust");
		Register r=lstreg.get(0);
		//Register r= new Register();
		Recharge rechargeobj=new Recharge(r.getRno(),mobno,rechargeamt,servicep);
		
		List<Recharge> lstrecharge=new ArrayList<Recharge>();
		lstrecharge.add(rechargeobj);
		
		RechargeDao rechargeDao=new RechargeDao();
		boolean b=rechargeDao.rechargeData(lstrecharge);
		if(b) {
			response.sendRedirect("RechargeDone.jsp");
		}
		else {
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
