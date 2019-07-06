package com.share.springboot1.model;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RedisHash("Post")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RedisPost {
	private Long id;
	private String postTitle;
	private String postBody;
	private User user;
	
	public RedisPost(Post post) {
		this.id = post.getId();
		this.postTitle = post.getPostTitle();
		this.postBody = post.getPostBody();
		this.user = post.getUser();
	}
		
}
