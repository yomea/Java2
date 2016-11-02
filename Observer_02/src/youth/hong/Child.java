package youth.hong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Child {
	private List<ActionListener> list = new ArrayList<ActionListener>();
	
	public Child() {
		Sleep s = new Sleep();
		new Thread(s).start();
	}
	
	public void wakeUp() {
		
		for (ActionListener actionListener : list) {
			ActionEvent ae = new ActionEvent(System.currentTimeMillis(), "´²", this);
			actionListener.actionPerform(ae);
		}
		
	}

	
	public void addActionListener(ActionListener al) {
		list.add(al);
	}
	
	private class Sleep implements Runnable {

		@Override
		public void run() {
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(10000));
				if(list.size() != 0) {
					wakeUp();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
