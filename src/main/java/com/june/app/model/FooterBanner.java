package com.june.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * Changer 객체
 *
 * @author trk
 */
@Entity
@Table(name = "footerbanner")
@DynamicUpdate
public class FooterBanner extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "bannername", columnDefinition = "VARCHAR(400)")
	@NotEmpty
	private String bannername; // 공통 이름

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "updated_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime updated_at = new LocalDateTime();

	@Column(name = "position", columnDefinition = "INT")
	private String position;

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	private String use_at;

	@Transient
	private MultipartFile file_image_ko;
	@Transient
	private MultipartFile file_image_en;
	@Transient
	private MultipartFile file_image_jp;
	@Transient
	private MultipartFile file_image_cn;
	@Transient
	private MultipartFile file_image_tw;

	@Column(name = "image_ko", columnDefinition = "VARCHAR(200)")
	private String image_ko;
	@Column(name = "image_en", columnDefinition = "VARCHAR(200)")
	private String image_en;
	@Column(name = "image_jp", columnDefinition = "VARCHAR(200)")
	private String image_jp;
	@Column(name = "image_cn", columnDefinition = "VARCHAR(200)")
	private String image_cn;
	@Column(name = "image_tw", columnDefinition = "VARCHAR(200)")
	private String image_tw;

	@Column(name = "url_link_ko", columnDefinition = "VARCHAR(600)")
	private String url_link_ko;
	@Column(name = "url_link_en", columnDefinition = "VARCHAR(600)")
	private String url_link_en;
	@Column(name = "url_link_jp", columnDefinition = "VARCHAR(600)")
	private String url_link_jp;
	@Column(name = "url_link_cn", columnDefinition = "VARCHAR(600)")
	private String url_link_cn;
	@Column(name = "url_link_tw", columnDefinition = "VARCHAR(600)")
	private String url_link_tw;

	@Column(name = "use_at_ko", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at_ko = "Y";
	@Column(name = "use_at_en", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at_en = "Y";
	@Column(name = "use_at_jp", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at_jp = "Y";
	@Column(name = "use_at_cn", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at_cn = "Y";
	@Column(name = "use_at_tw", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at_tw = "Y";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBannername() {
		return bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUse_at() {
		return use_at;
	}

	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}

	public MultipartFile getFile_image_ko() {
		return file_image_ko;
	}

	public void setFile_image_ko(MultipartFile file_image_ko) {
		this.file_image_ko = file_image_ko;
	}

	public MultipartFile getFile_image_en() {
		return file_image_en;
	}

	public void setFile_image_en(MultipartFile file_image_en) {
		this.file_image_en = file_image_en;
	}

	public MultipartFile getFile_image_jp() {
		return file_image_jp;
	}

	public void setFile_image_jp(MultipartFile file_image_jp) {
		this.file_image_jp = file_image_jp;
	}

	public MultipartFile getFile_image_cn() {
		return file_image_cn;
	}

	public void setFile_image_cn(MultipartFile file_image_cn) {
		this.file_image_cn = file_image_cn;
	}

	public MultipartFile getFile_image_tw() {
		return file_image_tw;
	}

	public void setFile_image_tw(MultipartFile file_image_tw) {
		this.file_image_tw = file_image_tw;
	}

	public String getImage_ko() {
		return image_ko;
	}

	public void setImage_ko(String image_ko) {
		this.image_ko = image_ko;
	}

	public String getImage_en() {
		return image_en;
	}

	public void setImage_en(String image_en) {
		this.image_en = image_en;
	}

	public String getImage_jp() {
		return image_jp;
	}

	public void setImage_jp(String image_jp) {
		this.image_jp = image_jp;
	}

	public String getImage_cn() {
		return image_cn;
	}

	public void setImage_cn(String image_cn) {
		this.image_cn = image_cn;
	}

	public String getImage_tw() {
		return image_tw;
	}

	public void setImage_tw(String image_tw) {
		this.image_tw = image_tw;
	}

	public String getUrl_link_ko() {
		return url_link_ko;
	}

	public void setUrl_link_ko(String url_link_ko) {
		this.url_link_ko = url_link_ko;
	}

	public String getUrl_link_en() {
		return url_link_en;
	}

	public void setUrl_link_en(String url_link_en) {
		this.url_link_en = url_link_en;
	}

	public String getUrl_link_jp() {
		return url_link_jp;
	}

	public void setUrl_link_jp(String url_link_jp) {
		this.url_link_jp = url_link_jp;
	}

	public String getUrl_link_cn() {
		return url_link_cn;
	}

	public void setUrl_link_cn(String url_link_cn) {
		this.url_link_cn = url_link_cn;
	}

	public String getUrl_link_tw() {
		return url_link_tw;
	}

	public void setUrl_link_tw(String url_link_tw) {
		this.url_link_tw = url_link_tw;
	}

	public String getUse_at_ko() {
		return use_at_ko;
	}

	public void setUse_at_ko(String use_at_ko) {
		this.use_at_ko = use_at_ko;
	}

	public String getUse_at_en() {
		return use_at_en;
	}

	public void setUse_at_en(String use_at_en) {
		this.use_at_en = use_at_en;
	}

	public String getUse_at_jp() {
		return use_at_jp;
	}

	public void setUse_at_jp(String use_at_jp) {
		this.use_at_jp = use_at_jp;
	}

	public String getUse_at_cn() {
		return use_at_cn;
	}

	public void setUse_at_cn(String use_at_cn) {
		this.use_at_cn = use_at_cn;
	}

	public String getUse_at_tw() {
		return use_at_tw;
	}

	public void setUse_at_tw(String use_at_tw) {
		this.use_at_tw = use_at_tw;
	}

	@Override
	public String toString() {
		return "FooterBanner [id=" + id + ", bannername=" + bannername + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", position=" + position + ", use_at=" + use_at + ", file_image_ko=" + file_image_ko
				+ ", file_image_en=" + file_image_en + ", file_image_jp=" + file_image_jp + ", file_image_cn="
				+ file_image_cn + ", file_image_tw=" + file_image_tw + ", image_ko=" + image_ko + ", image_en="
				+ image_en + ", image_jp=" + image_jp + ", image_cn=" + image_cn + ", image_tw=" + image_tw
				+ ", url_link_ko=" + url_link_ko + ", url_link_en=" + url_link_en + ", url_link_jp=" + url_link_jp
				+ ", url_link_cn=" + url_link_cn + ", url_link_tw=" + url_link_tw + ", use_at_ko=" + use_at_ko
				+ ", use_at_en=" + use_at_en + ", use_at_jp=" + use_at_jp + ", use_at_cn=" + use_at_cn + ", use_at_tw="
				+ use_at_tw + "]";
	}

}