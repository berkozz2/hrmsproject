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
@Table(name = "letter_of_approvals")
@NoArgsConstructor
@AllArgsConstructor
public class LetterOfApproval{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Onay yazısı Boş olamaz.")
	@Column(name = "text")
	private String text;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	@JsonIgnore
	private Candidate candidate;

}
