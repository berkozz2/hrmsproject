package hrmsproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "languages")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Dil Seviyesi Boş Geçilemez")
	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "degree")
	private int degree;
	
	@NotBlank(message = "Dil İsmi Boş Olamaz.")
	@Column(name = "language_name")
	private String languageName;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
