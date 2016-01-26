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
@Table(name = "promotion_locale")
public class PromotionLocale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "promotion_id", updatable = false, columnDefinition = "INT")
	private String promotion_id;

	@Column(name = "locale", updatable = false, columnDefinition = "VARCHAR(10)")
	@NotEmpty
	private String locale;

	@Column(name = "title", columnDefinition = "VARCHAR(400)")
	private String title;

	@Column(name = "descs", columnDefinition = "TEXT")
	private String descs;

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

	public String getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(String promotion_id) {
		this.promotion_id = promotion_id;
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

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
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
		return "PromotionLocale [id=" + id + ", promotion_id=" + promotion_id + ", locale=" + locale + ", title="
				+ title + ", descs=" + descs + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
