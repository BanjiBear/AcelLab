package io.acellab.service.web.startline.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "collaborators")
public class CollaboratorsInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "collab_id_1")
	private UserInfo collabId1;

	@ManyToOne
	@JoinColumn(name = "collab_id_2")
	private UserInfo collabId2;

	@ManyToOne
	@JoinColumn(name = "collab_id_3")
	private UserInfo collabId3;

	@ManyToOne
	@JoinColumn(name = "collab_id_4")
	private UserInfo collabId4;

	@ManyToOne
	@JoinColumn(name = "collab_id_5")
	private UserInfo collabId5;
	
	
	public Long getId() {return this.id;}
	
	public void setCollabId1(UserInfo collabId1) {this.collabId1 = collabId1;}
	public UserInfo getCollabId1() {return this.collabId1;}
	
	public void setCollabId2(UserInfo collabId2) {this.collabId2 = collabId2;}
	public UserInfo getCollabId2() {return this.collabId2;}
	
	public void setCollabId3(UserInfo collabId3) {this.collabId3 = collabId3;}
	public UserInfo getCollabId3() {return this.collabId3;}
	
	public void setCollabId4(UserInfo collabId4) {this.collabId4 = collabId4;}
	public UserInfo getCollabId4() {return this.collabId4;}
	
	public void setCollabId5(UserInfo collabId5) {this.collabId5 = collabId5;}
	public UserInfo getCollabId5() {return this.collabId5;}

}