package com.gura.spring05.android;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class AndroidController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AndroidDao androidDao;
	
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
	/*
	 *  Dto 를 리턴하고 @ResponseBody 어노 테에션을 붙여도 
	 *  Map 을 리턴한것과 동일하게 응답된다.
	 *  {"num":1,"name":"김구라","addr":"노량진"}
	 */
	@ResponseBody
	@RequestMapping("/android/member/detail")
	public MemberDto memberDetail(@RequestParam int num) {
	
		return memberDao.getData(num);
	}
	
	@ResponseBody
	@RequestMapping("/android/member/delete")
	public String memberDelete(@RequestParam int num) {
		
		memberDao.delete(num);
		
		return "{\"isSuccess\":true}";
	}
	/*
	 *   name=김구라&addr=노량진
	 *   
	 *   MemberDto dto=new MemberDto();
	 *   dto.setName(name);
	 *   dto.setAddr(addr);
	 */
	@ResponseBody
	@RequestMapping("/android/member/insert")
	public String memberInsert(@ModelAttribute MemberDto dto) {
		memberDao.insert(dto);
		return "{\"isSuccess\":true}";
	}
	@ResponseBody
	@RequestMapping("/android/image/upload")
	public String imageUpload(HttpServletRequest request,
			ImageDto dto) {
		//파일을 저장할 폴더의 절대 경로를 얻어온다.
		String realPath=request.getServletContext().getRealPath("/upload");
		//콘솔창에 테스트 출력
		System.out.println(realPath);
		
		//MultipartFile 객체의 참조값 얻어오기
		//FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
		MultipartFile mFile=dto.getMyFile();
		//원본 파일명
		String orgFileName=mFile.getOriginalFilename();
		
		//저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		//디렉토리를 만들 파일 객체 생성
		File file=new File(filePath);
		if(!file.exists()){//디렉토리가 존재하지 않는다면
			file.mkdir();//디렉토리를 만든다.
		}
		//파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
		String saveFileName=
				System.currentTimeMillis()+orgFileName;
		try{
			//upload 폴더에 파일을 저장한다.
			mFile.transferTo(new File(filePath+saveFileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		//FileDto 객체에 추가 정보를 담는다.
		dto.setImagePath("/upload/"+saveFileName);
		//FileDao 객체를 이용해서 DB 에 저장하기
		androidDao.insert(dto);		
		
		return "{\"isSuccess\":true}";
	}
	
	@ResponseBody
	@RequestMapping("/android/image/list")
	public List<ImageDto> imageList(){
		
		return androidDao.getList();
	}
}












