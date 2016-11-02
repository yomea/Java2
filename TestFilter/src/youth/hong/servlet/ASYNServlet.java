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
				//�߳��еõ�request��response����ҵ��
				HttpServletRequest request = (HttpServletRequest) context.getRequest();
				HttpServletResponse response = (HttpServletResponse) context.getResponse();
				Thread.sleep(10000);
				try {
					response.getWriter().println("hello");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//���յ�filter�����ԣ������֧���첽�Ļ�����ô��ִ����ʮ���Ż�ִ��filter���к�����´��롣
				System.out.println("�߳���ɵ�ʱ�䣺" + new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	

}
