package com.june.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Theme 객체
 *
 * @author trk
 */

@Entity
@Table(name = "event_locale")
public class EventLocale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "event_id", updatable = false, columnDefinition = "INT")
	private String event_id;

	@Column(name = "locale", updatable = false, columnDefinition = "VARCHAR(10)")
	@NotEmpty
	private String locale;

	@Column(name = "title", columnDefinition = "VARCHAR(400)")
	private String title;

	@Column(name = "titleinfo", columnDefinition = "VARCHAR(400)")
	private String titleinfo;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "updated_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime updated_at = new LocalDateTime();

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at = "Y";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleinfo() {
		return titleinfo;
	}

	public void setTitleinfo(String titleinfo) {
		this.titleinfo = titleinfo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public String getUse_at() {
		return use_at;
	}

	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}

	@Override
	public String toString() {
		return "EventLocale [id=" + id + ", event_id=" + event_id + ", locale=" + locale + ", title=" + title
				+ ", titleinfo=" + titleinfo + ", content=" + content + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", use_at=" + use_at + "]";
	}

}
