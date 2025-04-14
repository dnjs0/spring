package com.test.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CommentDTO {
	private String seq;
	private String subject;
	private String name;
	private String regdate;
	private String bseq;

}
