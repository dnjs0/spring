package com.test.mybatis.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BoardDTO {
	private String seq;
	private String subject;
	private String name;
	private String regdate;
	
	private List<CommentDTO> comments;
}
