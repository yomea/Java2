package youth.hong;

import static java.lang.Math.random;
import static java.lang.Math.round;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	
	private int num;
	private InputStream inputStream;
	
	
	
	

	



	public InputStream getInputStream() {
		return inputStream;
	}





	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
		//this.num = HTMLDecoder.decode(num);
		System.out.println("sadfh" + num);
	}



	@Override
	public String execute() throws Exception {
		int result = (int)round(random()*10);
		System.out.println(result);
		if(result == num) {
			inputStream = new ByteArrayInputStream("Äã²Â¶ÔÁË".getBytes("utf-8"));
		} else {
			inputStream = new ByteArrayInputStream("Äã²Â´íÁË".getBytes("utf-8"));
		}
		
		return SUCCESS;
	}

	
}
