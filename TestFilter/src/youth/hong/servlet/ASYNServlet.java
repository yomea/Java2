package youth.hong.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ASYNServlet
 */
@WebServlet(asyncSupported=true)
public class ASYNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASYNServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsyncContext context = request.startAsync();
		System.out.println("ASYNsart" + new Date());
		new Thread(new Executor(context)).start();
		System.out.println("ASYNend" + new Date());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public class Executor implements Runnable {
		private AsyncContext context;
		
		public Executor(AsyncContext context) {
			this.context = context;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				//线程中得到request与response处理业务
				HttpServletRequest request = (HttpServletRequest) context.getRequest();
				HttpServletResponse response = (HttpServletResponse) context.getResponse();
				Thread.sleep(10000);
				try {
					response.getWriter().println("hello");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//按照的filter的特性，如果不支持异步的话，那么在执行完十秒后才会执行filter放行后的余下代码。
				System.out.println("线程完成的时间：" + new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	

}
