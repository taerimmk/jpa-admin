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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * Changer 객체
 *
 * @author trk
 */
@Entity
@Table(name = "company")
@DynamicUpdate
public class Company extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "parent_id", columnDefinition = "INT", nullable = true)
	private Integer parent_id = 0;

	@Column(name = "headstore", columnDefinition = "CHAR(1)")
	private String headstore = "N";

	@Column(name = "user_id", columnDefinition = "INT", updatable = false)
	private int user_id = 0;

	@Column(name = "theme_id", columnDefinition = "INT", nullable = true)
	private int theme_id;

	@Column(name = "lat", columnDefinition = "VARCHAR(100)")
	private String lat;

	@Column(name = "lon", columnDefinition = "VARCHAR(100)")
	private String lon;

	@Column(name = "created_at", updatable = false, columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime created_at = new LocalDateTime();

	@Column(name = "updated_at", columnDefinition = "datetime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	private LocalDateTime updated_at = new LocalDateTime();

	@Column(name = "logo", columnDefinition = "VARCHAR(400)")
	private String logo;

	@Column(name = "position", columnDefinition = "INT")
	private int position;

	@Column(name = "small_store", columnDefinition = "VARCHAR(10)")
	private String small_store;

	@Column(name = "hot_coupons", columnDefinition = "VARCHAR(10)")
	private String hot_coupons;

	@Column(name = "year", columnDefinition = "VARCHAR(10)")
	private String year;

	// 메인노출여부
	@Column(name = "main_view", columnDefinition = "CHAR(1)")
	private String main_view;

	@Column(name = "use_at", columnDefinition = "CHAR(1)")
	private String use_at;

	@Column(name = "use_yn", columnDefinition = "CHAR(1)")
	private String use_yn;

	@Column(name = "fileuuid", updatable = false, columnDefinition = "CHAR(32)")
	private String fileuuid;
	/* 다국어영억 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private List<CompanyLocale> companyLocales;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "parent_id") private List<Company> branches;
	 */

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fileuuid", referencedColumnName = "fileuuid")
	@Transient
	private List<Imgs> imgs;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = true)
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInfo userInfo;

	@Column(name = "brancheCnt", columnDefinition = "INT")
	private Integer brancheCnt;

	@Transient
	private MultipartFile file_image1_wl;
	@Transient
	private MultipartFile file_image1_ws;
	@Transient
	private MultipartFile file_image2_wl;
	@Transient
	private MultipartFile file_image2_ws;
	@Transient
	private MultipartFile file_image3_wl;
	@Transient
	private MultipartFile file_image3_ws;
	@Transient
	private MultipartFile file_image4_wl;
	@Transient
	private MultipartFile file_image4_ws;
	@Transient
	private MultipartFile file_image5_wl;
	@Transient
	private MultipartFile file_image5_ws;
	@Transient
	private MultipartFile file_image_cp;
	@Transient
	private MultipartFile file_image_main;
	@Transient
	private MultipartFile file_image_list;

	@Column(name = "image1_wl", columnDefinition = "VARCHAR(200)")
	private String image1_wl;
	@Column(name = "image1_ws", columnDefinition = "VARCHAR(200)")
	private String image1_ws;
	@Column(name = "image2_wl", columnDefinition = "VARCHAR(200)")
	private String image2_wl;
	@Column(name = "image2_ws", columnDefinition = "VARCHAR(200)")
	private String image2_ws;
	@Column(name = "image3_wl", columnDefinition = "VARCHAR(200)")
	private String image3_wl;
	@Column(name = "image3_ws", columnDefinition = "VARCHAR(200)")
	private String image3_ws;
	@Column(name = "image4_wl", columnDefinition = "VARCHAR(200)")
	private String image4_wl;
	@Column(name = "image4_ws", columnDefinition = "VARCHAR(200)")
	private String image4_ws;
	@Column(name = "image5_wl", columnDefinition = "VARCHAR(200)")
	private String image5_wl;
	@Column(name = "image5_ws", columnDefinition = "VARCHAR(200)")
	private String image5_ws;
	@Column(name = "image_cp", columnDefinition = "VARCHAR(200)")
	private String image_cp;

	@Column(name = "image_main", columnDefinition = "VARCHAR(200)")
	private String image_main;

	@Column(name = "image_list", columnDefinition = "VARCHAR(200)")
	private String image_list;

	@Column(name = "season_off", columnDefinition = "CHAR(1)")
	private String season_off;

	@Transient
	private String locale;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getHeadstore() {
		return headstore;
	}

	public void setHeadstore(String headstore) {
		this.headstore = headstore;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(int theme_id) {
		this.theme_id = theme_id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getSmall_store() {
		return small_store;
	}

	public void setSmall_store(String small_store) {
		this.small_store = small_store;
	}

	public String getHot_coupons() {
		return hot_coupons;
	}

	public void setHot_coupons(String hot_coupons) {
		this.hot_coupons = hot_coupons;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMain_view() {
		return main_view;
	}

	public void setMain_view(String main_view) {
		this.main_view = main_view;
	}

	public String getUse_at() {
		return use_at;
	}

	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getFileuuid() {
		return fileuuid;
	}

	public void setFileuuid(String fileuuid) {
		this.fileuuid = fileuuid;
	}

	public List<CompanyLocale> getCompanyLocales() {
		return companyLocales;
	}

	public void setCompanyLocales(List<CompanyLocale> companyLocales) {
		this.companyLocales = companyLocales;
	}

	public List<Imgs> getImgs() {
		return imgs;
	}

	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getBrancheCnt() {
		return brancheCnt;
	}

	public void setBrancheCnt(Integer brancheCnt) {
		this.brancheCnt = brancheCnt;
	}

	public MultipartFile getFile_image1_wl() {
		return file_image1_wl;
	}

	public void setFile_image1_wl(MultipartFile file_image1_wl) {
		this.file_image1_wl = file_image1_wl;
	}

	public MultipartFile getFile_image1_ws() {
		return file_image1_ws;
	}

	public void setFile_image1_ws(MultipartFile file_image1_ws) {
		this.file_image1_ws = file_image1_ws;
	}

	public MultipartFile getFile_image2_wl() {
		return file_image2_wl;
	}

	public void setFile_image2_wl(MultipartFile file_image2_wl) {
		this.file_image2_wl = file_image2_wl;
	}

	public MultipartFile getFile_image2_ws() {
		return file_image2_ws;
	}

	public void setFile_image2_ws(MultipartFile file_image2_ws) {
		this.file_image2_ws = file_image2_ws;
	}

	public MultipartFile getFile_image3_wl() {
		return file_image3_wl;
	}

	public void setFile_image3_wl(MultipartFile file_image3_wl) {
		this.file_image3_wl = file_image3_wl;
	}

	public MultipartFile getFile_image3_ws() {
		return file_image3_ws;
	}

	public void setFile_image3_ws(MultipartFile file_image3_ws) {
		this.file_image3_ws = file_image3_ws;
	}

	public MultipartFile getFile_image4_wl() {
		return file_image4_wl;
	}

	public void setFile_image4_wl(MultipartFile file_image4_wl) {
		this.file_image4_wl = file_image4_wl;
	}

	public MultipartFile getFile_image4_ws() {
		return file_image4_ws;
	}

	public void setFile_image4_ws(MultipartFile file_image4_ws) {
		this.file_image4_ws = file_image4_ws;
	}

	public MultipartFile getFile_image5_wl() {
		return file_image5_wl;
	}

	public void setFile_image5_wl(MultipartFile file_image5_wl) {
		this.file_image5_wl = file_image5_wl;
	}

	public MultipartFile getFile_image5_ws() {
		return file_image5_ws;
	}

	public void setFile_image5_ws(MultipartFile file_image5_ws) {
		this.file_image5_ws = file_image5_ws;
	}

	public MultipartFile getFile_image_cp() {
		return file_image_cp;
	}

	public void setFile_image_cp(MultipartFile file_image_cp) {
		this.file_image_cp = file_image_cp;
	}

	public MultipartFile getFile_image_main() {
		return file_image_main;
	}

	public void setFile_image_main(MultipartFile file_image_main) {
		this.file_image_main = file_image_main;
	}

	public MultipartFile getFile_image_list() {
		return file_image_list;
	}

	public void setFile_image_list(MultipartFile file_image_list) {
		this.file_image_list = file_image_list;
	}

	public String getImage1_wl() {
		return image1_wl;
	}

	public void setImage1_wl(String image1_wl) {
		this.image1_wl = image1_wl;
	}

	public String getImage1_ws() {
		return image1_ws;
	}

	public void setImage1_ws(String image1_ws) {
		this.image1_ws = image1_ws;
	}

	public String getImage2_wl() {
		return image2_wl;
	}

	public void setImage2_wl(String image2_wl) {
		this.image2_wl = image2_wl;
	}

	public String getImage2_ws() {
		return image2_ws;
	}

	public void setImage2_ws(String image2_ws) {
		this.image2_ws = image2_ws;
	}

	public String getImage3_wl() {
		return image3_wl;
	}

	public void setImage3_wl(String image3_wl) {
		this.image3_wl = image3_wl;
	}

	public String getImage3_ws() {
		return image3_ws;
	}

	public void setImage3_ws(String image3_ws) {
		this.image3_ws = image3_ws;
	}

	public String getImage4_wl() {
		return image4_wl;
	}

	public void setImage4_wl(String image4_wl) {
		this.image4_wl = image4_wl;
	}

	public String getImage4_ws() {
		return image4_ws;
	}

	public void setImage4_ws(String image4_ws) {
		this.image4_ws = image4_ws;
	}

	public String getImage5_wl() {
		return image5_wl;
	}

	public void setImage5_wl(String image5_wl) {
		this.image5_wl = image5_wl;
	}

	public String getImage5_ws() {
		return image5_ws;
	}

	public void setImage5_ws(String image5_ws) {
		this.image5_ws = image5_ws;
	}

	public String getImage_cp() {
		return image_cp;
	}

	public void setImage_cp(String image_cp) {
		this.image_cp = image_cp;
	}

	public String getImage_main() {
		return image_main;
	}

	public void setImage_main(String image_main) {
		this.image_main = image_main;
	}

	public String getImage_list() {
		return image_list;
	}

	public void setImage_list(String image_list) {
		this.image_list = image_list;
	}

	public String getSeason_off() {
		return season_off;
	}

	public void setSeason_off(String season_off) {
		this.season_off = season_off;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}