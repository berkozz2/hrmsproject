package hrmsproject.hrms.entities.dtos;

import java.util.List;

import hrmsproject.hrms.entities.concretes.Candidate;
import hrmsproject.hrms.entities.concretes.CandidateAbility;
import hrmsproject.hrms.entities.concretes.CandidateEducation;
import hrmsproject.hrms.entities.concretes.CandidateExperience;
import hrmsproject.hrms.entities.concretes.CandidateLanguage;
import hrmsproject.hrms.entities.concretes.CandidateLink;
import hrmsproject.hrms.entities.concretes.Image;
import hrmsproject.hrms.entities.concretes.LetterOfApproval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	private Candidate candidate;
	private Image image;
	private List<CandidateLink> links;
	private List<CandidateLanguage> languages;
	private List<CandidateAbility> abilities;
	private List<CandidateEducation> educations;
	private List<LetterOfApproval> letters;
	private List<CandidateExperience> experiences;
	
	
}
