package com.june.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "promotion")
public class Promotion extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "menu", columnDefinition = "VARCHAR(400)")
	@NotEmpty
	private String menu; // 메뉴명

	@Column(name = "position", columnDefinition = "INT(4)")
	private int position; // 정렬순서

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at = "Y";

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "promotion_id")
	private List<PromotionLocale> promotionLocales;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
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

	public String getUse_at() {
		return use_at;
	}

	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}

	public List<PromotionLocale> getPromotionLocales() {
		return promotionLocales;
	}

	public void setPromotionLocales(List<PromotionLocale> promotionLocales) {
		this.promotionLocales = promotionLocales;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", menu=" + menu + ", position=" + position + ", created_at=" + created_at
				+ ", use_at=" + use_at + ", promotionLocales=" + promotionLocales + "]";
	}

}
