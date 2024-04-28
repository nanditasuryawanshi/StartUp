package com.training.entityService;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="TrainingCenters")
public class TrainingCenters 
{
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "centerName", nullable = false)
    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @Column(name = "centerCode", nullable = false, unique = true)
    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "\\w{12}", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    @NotNull
    private Address address;

    @Column(name = "studentCapacity")
    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(name = "createdOn", nullable = false)
    private long createdOn;

    @Column(name = "contactEmail")
    @Email(message = "Invalid email format")
    private String contactEmail;

    @Column(name = "contactPhone", nullable = false, unique = true)
    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format")
    private String contactPhone;

    
    // Populate createdOn with current epoch time
    @PrePersist
    public void prePersist() {
        createdOn = System.currentTimeMillis(); 
    }
    
    
    
    //Generate getters and setters
    
	public TrainingCenters(Long id,
			@NotBlank(message = "Center name is required") @Size(max = 40, message = "Center name must be less than 40 characters") String centerName,
			@NotBlank(message = "Center code is required") @Pattern(regexp = "\\w{12}", message = "Center code must be exactly 12 alphanumeric characters") String centerCode,
			@NotNull Address address, Integer studentCapacity, List<String> coursesOffered, long createdOn,
			@Email(message = "Invalid email format") String contactEmail,
			@NotBlank(message = "Contact phone is required") @Pattern(regexp = "\\d{10}", message = "Invalid phone number format") String contactPhone) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	public TrainingCenters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


}
