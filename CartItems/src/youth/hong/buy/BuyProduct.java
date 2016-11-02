package youth.hong.buy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import youth.hong.cart.Cart;
import youth.hong.dao.ItemsDao;
import youth.hong.items.Items;

/**
 * Servlet implementation class BuyProduct
 */
@WebServlet("/BuyProduct")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.action = request.getParameter("action");
		if(action == null) {
			PrintWriter out = response.getWriter();
			out.print("没有动作");
			return;
		}
		if(action.equals("addToCart")) {
			if(add(request,response)) {
				response.sendRedirect(request.getContextPath() + "/listproduct.jsp");
			}
		}
	}
	
	private boolean add(HttpServletRequest request, HttpServletResponse response) {
		String strId = request.getParameter("id");
		String strCount = request.getParameter("count");
		int id = 0;
		int count = 1;
		if(strId != null && strCount != null) {
			try {
				id = Integer.parseInt(strId);
				count = Integer.parseInt(strCount);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
		
		HttpSession session = request.getSession();
		ItemsDao itd = new ItemsDao();
		Items item = itd.getItemById(id);
		Cart c = (Cart)session.getAttribute("cart");
		if(c == null) {
			c = new Cart();
			
		}
		c.addItems(item, count);
		
		session.setAttribute("cart", c);
		System.out.println("ok");
		
		return true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
