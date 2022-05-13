package project.service;

import project.dao.PostDao;
import project.model.PostModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PostService {
	PostDao p;
	
	@Autowired
	public PostService(PostDao p) {
		super();
		this.p = p;
	}
	

	public void postPost(PostModel post) {
		p.save(post);
		
	}
	

}
