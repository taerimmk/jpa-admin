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
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * Theme 객체
 *
 * @author trk
 */
@Entity
@Table(name = "event")
public class Event extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; // 공통 아이디

	@Column(name = "eventname", columnDefinition = "VARCHAR(400)")
	@NotEmpty
	private String eventname; // 공통 이름

	@Column(name = "position", columnDefinition = "INT(4)")
	private int position; // 정렬순서

	@Column(name = "start_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime start_at = new LocalDateTime();

	@Column(name = "end_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime end_at = new LocalDateTime();

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at = "Y";

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private List<EventLocale> eventLocales;

	@Column(name = "fileuuid", updatable = false, columnDefinition = "CHAR(32)")
	private String fileuuid;

	@Transient
	private MultipartFile file;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fileuuid", referencedColumnName = "fileuuid")
	@Transient
	private Imgs imgs;

	@Column(name = "image", columnDefinition = "VARCHAR(200)")
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public LocalDateTime getStart_at() {
		return start_at;
	}

	public void setStart_at(LocalDateTime start_at) {
		this.start_at = start_at;
	}

	public LocalDateTime getEnd_at() {
		return end_at;
	}

	public void setEnd_at(LocalDateTime end_at) {
		this.end_at = end_at;
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

	public List<EventLocale> getEventLocales() {
		return eventLocales;
	}

	public void setEventLocales(List<EventLocale> eventLocales) {
		this.eventLocales = eventLocales;
	}

	public String getFileuuid() {
		return fileuuid;
	}

	public void setFileuuid(String fileuuid) {
		this.fileuuid = fileuuid;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Imgs getImgs() {
		return imgs;
	}

	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventname=" + eventname + ", position=" + position + ", start_at=" + start_at
				+ ", end_at=" + end_at + ", created_at=" + created_at + ", use_at=" + use_at + ", eventLocales="
				+ eventLocales + ", fileuuid=" + fileuuid + ", file=" + file + ", imgs=" + imgs + ", image=" + image
				+ "]";
	}

}
