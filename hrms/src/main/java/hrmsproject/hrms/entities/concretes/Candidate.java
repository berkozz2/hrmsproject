package hrmsproject.hrms.entities.concretes;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "candidates")
public class Candidate extends User {
	
	
	@Column(name = "first_name")
	private String firstName;
	
	
	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "identity_number")
	private String idendityNumber;
	
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateExperience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLanguage> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateEducation> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<LetterOfApproval> letters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLink> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateAbility> abilities;
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private Image image;
}
