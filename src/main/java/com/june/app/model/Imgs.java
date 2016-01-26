package com.june.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "imgs")
public class Imgs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "master_id", columnDefinition = "INT")
	private int master_id;

	@Column(name = "fileuuid", updatable = false, columnDefinition = "CHAR(32)")
	private String fileuuid;

	@Column(name = "type", columnDefinition = "VARCHAR(10)")
	private String type;

	@Column(name = "name", columnDefinition = "VARCHAR(200)")
	private String name;

	@Column(name = "oName", columnDefinition = "VARCHAR(200)")
	private String oName;

	@Column(name = "ext", columnDefinition = "VARCHAR(10)")
	private String ext;

	@Column(name = "url", columnDefinition = "VARCHAR(200)")
	private String url;

	@Column(name = "xRes", columnDefinition = "VARCHAR(10)")
	private String xRes;

	@Column(name = "yRes", columnDefinition = "VARCHAR(10)")
	private String yRes;

	@Column(name = "created_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "position", columnDefinition = "INT")
	private String position;

	@Transient
	private MultipartFile imgFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaster_id() {
		return master_id;
	}

	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}

	public String getFileuuid() {
		return fileuuid;
	}

	public void setFileuuid(String fileuuid) {
		this.fileuuid = fileuuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getxRes() {
		return xRes;
	}

	public void setxRes(String xRes) {
		this.xRes = xRes;
	}

	public String getyRes() {
		return yRes;
	}

	public void setyRes(String yRes) {
		this.yRes = yRes;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "Imgs [id=" + id + ", fileuuid=" + fileuuid + ", type=" + type + ", name=" + name + ", oName=" + oName
				+ ", ext=" + ext + ", url=" + url + ", xRes=" + xRes + ", yRes=" + yRes + ", created_at=" + created_at
				+ ", position=" + position + ", imgFile=" + imgFile + "]";
	}

}
