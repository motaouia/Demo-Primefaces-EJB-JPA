package org.medmota.demo.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.medmota.demo.models.BlogEntry;
import org.medmota.demo.services.BlogService;

@Named(value ="blogEntryBean")
@RequestScoped
public class BlogEntryBean {

	@Inject
	private BlogService blogService;
	private BlogEntry blogEntry;
	
	@PostConstruct
	public void init() {
		blogEntry = new BlogEntry();
	}
	public List<BlogEntry> getBlogEntries() {
	  return blogService.listAllBlogEntries();
	}
	
	public void delete(BlogEntry blogEntry) {
		blogService.deleteBlogEntry(blogEntry.getId());
	}

	public BlogEntry getBlogEntry() {
		return blogEntry;
	}

	public void setBlogEntry(BlogEntry blogEntry) {
		this.blogEntry = blogEntry;
	}
	
	public String saveBlogEntry() {
		blogService.createBlogEntry(blogEntry);
		return "success";
	}
	
}