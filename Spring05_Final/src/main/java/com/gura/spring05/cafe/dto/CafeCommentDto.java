package com.gura.spring05.cafe.dto;

public class CafeCommentDto {
	private int num;
	private String writer;
	private String content; //댓글 내용
	private String target_id; //댓글 대상자의 아이디
	private int ref_group; //댓글의 그룹번호 (원글의 글번호가 댓글의 그룹번호가 된다)
	private int comment_group; //댓글 내에서의 그룹번호 (댓글의 댓글 처리 하기 위해)
	private String deleted; // 삭제한 댓글인지 여부  "no" | "yes"
	private String regdate; 
	private String profile; //댓글 작성자의 프로필 이미지 경로를 담을 필드 
	
	//디폴트 생성자
	public CafeCommentDto() {}

	public CafeCommentDto(int num, String writer, String content, String target_id, int ref_group, int comment_group,
			String deleted, String regdate, String profile) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.target_id = target_id;
		this.ref_group = ref_group;
		this.comment_group = comment_group;
		this.deleted = deleted;
		this.regdate = regdate;
		this.profile = profile;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}

	public int getComment_group() {
		return comment_group;
	}

	public void setComment_group(int comment_group) {
		this.comment_group = comment_group;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}


