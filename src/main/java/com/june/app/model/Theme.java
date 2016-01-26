package com.june.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "theme")
public class Theme extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title", columnDefinition = "VARCHAR(400)")
	@NotEmpty
	private String title;

	@Column(name = "parent_id", columnDefinition = "INT(4)", nullable = true)
	private int parent_id;

	@Column(name = "position", columnDefinition = "INT(4)")
	private int position;

	@Column(name = "created_at", columnDefinition = "datetime", updatable = false)
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "theme_id")
	private List<ThemeLocale> themeLocales;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	@OrderBy("position ASC")
	private List<Theme> themeSub;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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

	public List<ThemeLocale> getThemeLocales() {
		return themeLocales;
	}

	public void setThemeLocales(List<ThemeLocale> themeLocales) {
		this.themeLocales = themeLocales;
	}

	public List<Theme> getThemeSub() {
		return themeSub;
	}

	public void setThemeSub(List<Theme> themeSub) {
		this.themeSub = themeSub;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", title=" + title + ", parent_id=" + parent_id + ", position=" + position
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", use_at=" + use_at + ", themeLocales="
				+ themeLocales + "]";
	}

}
