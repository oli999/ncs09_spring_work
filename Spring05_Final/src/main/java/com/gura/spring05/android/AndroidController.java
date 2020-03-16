package com.gura.spring05.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring05.member.dao.MemberDao;

@Controller
public class AndroidController {
	
	@Autowired
	private MemberDao memberDao;
	
	/*
	 * 	["김구라","해골","원숭이"] 형식의 문자열이 응답되는 메소드 
	 */
	@ResponseBody
	@RequestMapping("/android/getnames")
	public List<String> getNames(){
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		return names;
	}
	/*
	 *  {"num":1,"name":"김구라","isMan":true} 형식의 
	 *  json 문자열이 응답된다. 
	 */
	@ResponseBody
	@RequestMapping("/android/getdetail")
	public Map<String, Object> getDetail(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		return map;
	}
	@ResponseBody
	@RequestMapping("/android/getmember")
	public List<Map<String, Object>> getMember(){
		
		return memberDao.getList2();
	}
	
	@ResponseBody
	@RequestMapping("/android/member/list.do")
	public List<Map<String, Object>> memberGetList(){
		
		return memberDao.memberGetList();
	}
	
}












