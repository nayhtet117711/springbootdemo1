package com.share.springboot1.repo;

import org.springframework.data.repository.CrudRepository;

import com.share.springboot1.model.RedisPost;

public interface RedisPostRepo extends CrudRepository<RedisPost, String> {

}
