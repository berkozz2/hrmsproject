package hrmsproject.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verification_codes")
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "verification_code")
	private String code;
	
	@Column(name = "confirm_date")
	private Date confirmDate;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name= "is_verify")
	private boolean isVerified;
	
	public boolean isVerify() {
		return this.isVerified;
	}
	
}
