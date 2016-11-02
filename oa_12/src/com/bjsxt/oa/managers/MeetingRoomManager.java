package com.bjsxt.oa.managers;

import java.util.Date;
import java.util.List;

import com.bjsxt.oa.model.MeetingRoom;
import com.bjsxt.oa.model.MeetingRoomApply;

public interface MeetingRoomManager {
	public void addRoom(MeetingRoom room);
	public void applyRoom(MeetingRoomApply apply,String sn);
	public MeetingRoomApply findRoomApply(int applyId);
	public void updateApply(MeetingRoomApply apply,String sn);
	
	/**
	 * ����������
	 * @return
	 */
	public List searchAllRooms();
	
	/**
	 * ���������������¼
	 * @param begin
	 * @param end
	 * @return
	 */
	public List searchApplies(Date begin,Date end);
}
