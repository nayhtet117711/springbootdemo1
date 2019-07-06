package com.share.springboot1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postTitle;
	private String postBody;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Post(RedisPost post) {
		this.id = post.getId();
		this.postTitle = post.getPostTitle();
		this.postBody = post.getPostBody();
		this.user = post.getUser();
	}
		
}
