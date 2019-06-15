package mum.edu.cs.cs425.project.ecarrent.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@Column(name = "reference_number")
	@NotNull
	private String referenceNumber;
	
	@Column(name = "booking_date")
	@NotNull(message = "*Please provide booking date")
	private LocalDate bookingDate;

	@Column(name = "start_date_time")
	@NotNull(message = "*Please provide booking start date and time")
    private LocalDateTime startDateTime;

	@Column(name = "end_date_time")
	@NotNull(message = "*Please provide booking end date and time")
    private LocalDateTime endDateTime;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false, unique = true)
	private User user;
	
	@OneToOne
	@JoinColumn(name="payment_id", nullable = true, unique = true)
	private Payment payment;

    public Booking() {}
    
	public Booking(Long bookingId, String referenceNumber, LocalDate bookingDate, LocalDateTime startDateTime, 
			LocalDateTime endDateTime, Vehicle vehicle, User user, Payment payment) {
		this.bookingId = bookingId;
		this.referenceNumber = referenceNumber;
		this.bookingDate = bookingDate;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.vehicle = vehicle;
		this.user = user;
		this.payment = payment;
	}
	
	public Booking(Long bookingId, LocalDate bookingDate, LocalDateTime startDateTime, 
			LocalDateTime endDateTime, User user) {
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.user = user;
	}



	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}