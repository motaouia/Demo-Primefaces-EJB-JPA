package org.medmota.demo.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.medmota.demo.models.BlogEntry;

@Stateless
public class BlogService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public BlogEntry createBlogEntry(BlogEntry blogEntry) {
		entityManager.persist(blogEntry);
		return blogEntry;
	}
	
	public List<BlogEntry> listAllBlogEntries(){
		return entityManager.createQuery("SELECT be from BlogEntry be ").getResultList();
	}

	public void deleteBlogEntry(Long id) {
		 entityManager.remove(entityManager.find(BlogEntry.class, id));
	}
}
