package com.june.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Theme 객체
 *
 * @author trk
 */
@Entity
@Table(name = "main")
public class Main extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "season_off", columnDefinition = "CHAR(1)")
	private String season_off = "N";

	@Column(name = "contents_ko", columnDefinition = "VARCHAR(800)")
	private String contents_ko;

	@Column(name = "contents_en", columnDefinition = "VARCHAR(800)")
	private String contents_en;

	@Column(name = "contents_jp", columnDefinition = "VARCHAR(800)")
	private String contents_jp;

	@Column(name = "contents_cn", columnDefinition = "VARCHAR(800)")
	private String contents_cn;

	@Column(name = "contents_tw", columnDefinition = "VARCHAR(800)")
	private String contents_tw;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeason_off() {
		return season_off;
	}

	public void setSeason_off(String season_off) {
		this.season_off = season_off;
	}

	public String getContents_ko() {
		return contents_ko;
	}

	public void setContents_ko(String contents_ko) {
		this.contents_ko = contents_ko;
	}

	public String getContents_en() {
		return contents_en;
	}

	public void setContents_en(String contents_en) {
		this.contents_en = contents_en;
	}

	public String getContents_jp() {
		return contents_jp;
	}

	public void setContents_jp(String contents_jp) {
		this.contents_jp = contents_jp;
	}

	public String getContents_cn() {
		return contents_cn;
	}

	public void setContents_cn(String contents_cn) {
		this.contents_cn = contents_cn;
	}

	public String getContents_tw() {
		return contents_tw;
	}

	public void setContents_tw(String contents_tw) {
		this.contents_tw = contents_tw;
	}

	@Override
	public String toString() {
		return "Main [id=" + id + ", season_off=" + season_off + ", contents_ko=" + contents_ko + ", contents_en="
				+ contents_en + ", contents_jp=" + contents_jp + ", contents_cn=" + contents_cn + ", contents_tw="
				+ contents_tw + "]";
	}

}
