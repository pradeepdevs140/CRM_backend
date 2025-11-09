package customer.service.crm.Entity;



import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public UserEntity(Long id, String userId, String name, String email, String password, String verifyOTP,
			boolean isAccountVerified, Long verifyOtpExpireAt, String resetOtp, Long resetOtpExpireAt,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.verifyOTP = verifyOTP;
		this.isAccountVerified = isAccountVerified;
		this.verifyOtpExpireAt = verifyOtpExpireAt;
		this.resetOtp = resetOtp;
		this.resetOtpExpireAt = resetOtpExpireAt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserEntity() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyOTP() {
		return verifyOTP;
	}

	public void setVerifyOTP(String verifyOTP) {
		this.verifyOTP = verifyOTP;
	}

	public boolean isAccountVerified() {
		return isAccountVerified;
	}

	public void setAccountVerified(boolean isAccountVerified) {
		this.isAccountVerified = isAccountVerified;
	}

	public Long getVerifyOtpExpireAt() {
		return verifyOtpExpireAt;
	}

	public void setVerifyOtpExpireAt(Long verifyOtpExpireAt) {
		this.verifyOtpExpireAt = verifyOtpExpireAt;
	}

	public String getResetOtp() {
		return resetOtp;
	}

	public void setResetOtp(String resetOtp) {
		this.resetOtp = resetOtp;
	}

	public Long getResetOtpExpireAt() {
		return resetOtpExpireAt;
	}

	public void setResetOtpExpireAt(Long resetOtpExpireAt) {
		this.resetOtpExpireAt = resetOtpExpireAt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(unique=true)
	private String userId;
	private String name;
	
	private String email;
	
	private String password;
	
	private String verifyOTP;
	
	private boolean isAccountVerified;
	
	private Long verifyOtpExpireAt;
	
	private String resetOtp;
	
	private Long resetOtpExpireAt;
	
	@CreationTimestamp
	@Column(updatable=false)
	private Timestamp createdAt;
	
	@UpdateTimestamp
	private Timestamp updatedAt;
}

