package hrmsproject.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "requirements")
	private String requirement;
	
	//@Column(name = "city_id")
	//private int cityId;
	
	//@Column(name = "employer_id")
	//private int employerId;
	
	//@Column(name = "title_id")
	//private int titleId;
	
	@Column(name = "open_position")
	private boolean openPosition;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "application_date")
	private Date applicationDate;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@ManyToOne
	@JoinColumn(name = "title_id")
	private JobTitle jobtitle;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "work_time_id")
	private WorkTime workTime;
	
	@ManyToOne
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@OneToOne(mappedBy = "jobAdvertisement")
	private JobAdvertisementConfirm jobAdvertisementConfirm;
	
	
}
