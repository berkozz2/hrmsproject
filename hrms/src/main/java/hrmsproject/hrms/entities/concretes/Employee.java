package hrmsproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	

	@OneToMany(mappedBy = "employee")
	@JsonIgnore
	private List<JobAdvertisementConfirm> jobAdvertisementConfirms;

	/*@OneToMany(mappedBy = "employees")
	@JsonIgnore
	private JobAdvertisementConfirm jobAdvertisementConfirm;*/

}
