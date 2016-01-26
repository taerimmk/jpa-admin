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
@Table(name = "theme_locale")
public class ThemeLocale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "theme_id", updatable = false, columnDefinition = "INT")
	private int theme_id;

	@Column(name = "locale", updatable = false, columnDefinition = "VARCHAR(10)")
	@NotEmpty
	private String locale;

	@Column(name = "name", columnDefinition = "VARCHAR(400)")
	private String name;

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "updated_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime updated_at = new LocalDateTime();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(int theme_id) {
		this.theme_id = theme_id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "ThemeLocale [id=" + id + ", theme_id=" + theme_id + ", locale=" + locale + ", name=" + name
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
