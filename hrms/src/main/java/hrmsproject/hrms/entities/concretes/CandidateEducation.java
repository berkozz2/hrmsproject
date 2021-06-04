package hrmsproject.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "educations")
public class CandidateEducation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Okul Adı Girilmelidir.")
	@NotNull
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank(message = "Bölüm Girilmelidir.")
	@NotNull
	@Column(name = "major")
	private String major;
	
	@NotBlank(message = "Başlangıç Tarihi Girilmelidir.")
	@NotNull
	@Column(name = "started_date")
	private Date startedDate;
	
	@NotBlank(message = "Bitiş Tarihi Girilmelidir.")
	@NotNull
	@Column(name = "ended_date")
	private Date endedDate;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
