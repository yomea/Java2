package com.bjsxt.oa.managers;

import java.util.Calendar;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.oa.model.MeetingRoom;
import com.bjsxt.oa.model.MeetingRoomApply;

import junit.framework.TestCase;

public class MeetingRoomManagerTest extends TestCase {
	private static BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	public void testAddRoom() {
		MeetingRoomManager mrm = (MeetingRoomManager)factory.getBean("meetingRoomManager");
		for(int i=1; i<8; i++){
			MeetingRoom mr = new MeetingRoom();
			mr.setSn("10"+i);
			mrm.addRoom(mr);
		}
	}
//	
//	public void testApply(){
//		MeetingRoomManager mrm = (MeetingRoomManager)factory.getBean("meetingRoomManager");
//		MeetingRoomApply apply = new MeetingRoomApply();
//		apply.setApplyReason("Ô­ÒòÊÇÉ¶£¿");
//		Calendar begin = Calendar.getInstance();
//		begin.set(2007, 7 - 1, 3, 3, 21);
//		apply.setBeginDate(begin.getTime());
//		
//		Calendar end = Calendar.getInstance();
//		begin.set(2007, 7 - 1, 4, 3, 21);
//		apply.setEndDate(end.getTime());
//		
//		mrm.applyRoom(apply, 2);
//	}

}
