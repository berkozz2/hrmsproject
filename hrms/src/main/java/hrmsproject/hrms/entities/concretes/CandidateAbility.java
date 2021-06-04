package hrmsproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "abilities")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateAbility{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@NotBlank(message = "Yetenekler boş bırakılamaz.")
	@Column(name = "ability_name")
	private String abilityName;
	
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
