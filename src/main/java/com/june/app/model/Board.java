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
import javax.persistence.OneToOne;
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

/**
 * @author bhj
 *
 */
/**
 * @author bhj
 *
 */
@Entity
@Table(name = "board")
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "board_master_id", columnDefinition = "INT")
	private int board_master_id;

	@Column(name = "menu_id", columnDefinition = "INT")
	private String menu_id;

	@Column(name = "boardname", columnDefinition = "VARCHAR(400)")
	@NotEmpty
	private String boardname; // 메뉴명

	@Column(name = "position", columnDefinition = "INT(4)")
	private int position; // 정렬순서

	@Column(name = "readcnt", columnDefinition = "INT(4)")
	private Integer readcnt = 0; // 조회수

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	@NotEmpty
	private String use_at = "Y";

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "board_id", updatable=false, insertable=false)
	private List<BoardLocale> boardLocales;

	@OneToOne
	@JoinColumn(name = "board_master_id", insertable = false, updatable = false)
	private BoardMaster boardMst;
	/*
	 * @ManyToOne(fetch=FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "board_master_id", insertable = false, updatable =
	 * false) private BoardMaster boardMst;
	 */

	@Column(name = "fileuuid", updatable = false, columnDefinition = "CHAR(32)")
	private String fileuuid;

	@Transient
	private MultipartFile file;

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

	public int getBoard_master_id() {
		return board_master_id;
	}

	public void setBoard_master_id(int board_master_id) {
		this.board_master_id = board_master_id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Integer getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(Integer readcnt) {
		this.readcnt = readcnt;
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

	public List<BoardLocale> getBoardLocales() {
		return boardLocales;
	}

	public void setBoardLocales(List<BoardLocale> boardLocales) {
		this.boardLocales = boardLocales;
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

	public BoardMaster getBoardMst() {
		return boardMst;
	}

	public void setBoardMst(BoardMaster boardMst) {
		this.boardMst = boardMst;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", board_master_id=" + board_master_id + ", menu_id=" + menu_id + ", boardname="
				+ boardname + ", position=" + position + ", readcnt=" + readcnt + ", created_at=" + created_at
				+ ", use_at=" + use_at + ", boardLocales=" + boardLocales + ", boardMst=" + boardMst + ", fileuuid="
				+ fileuuid + ", file=" + file + ", imgs=" + imgs + ", image=" + image + "]";
	}

}
