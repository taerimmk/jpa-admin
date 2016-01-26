package com.june.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Theme 객체
 *
 * @author trk
 */
@Entity
@Table(name = "board_master", uniqueConstraints = { @UniqueConstraint(columnNames = { "mastername" }) })
public class BoardMaster extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "mastername", columnDefinition = "VARCHAR(400)")
	private String mastername; // 카테고리명

	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "boardMst") private
	 * List<Board> boards;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMastername() {
		return mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	@Override
	public String toString() {
		return "BoardMaster [id=" + id + ", mastername=" + mastername + "]";
	}

}
