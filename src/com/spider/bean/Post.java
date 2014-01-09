package com.spider.bean;

/**
 * Created by kai.wang on 1/6/14.
 */
public class Post {
	private String title = "";
	private String content = "";
	private String createAt = "";
	private String tag = "";
	private String images = "";
	private String cover = "";
	private String author = "";
	private String fromName = "";
	private String fromLink = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getFromLink() {
		return fromLink;
	}

	public void setFromLink(String fromLink) {
		this.fromLink = fromLink;
	}

	@Override
	public String toString() {
		return "Post{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", createAt='" + createAt + '\'' +
				", tag='" + tag + '\'' +
				", images='" + images + '\'' +
				", cover='" + cover + '\'' +
				", author='" + author + '\'' +
				", fromName='" + fromName + '\'' +
				", fromLink='" + fromLink + '\'' +
				'}';
	}
}
