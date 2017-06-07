package bluecode.mx.jpa.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TBL_TO_DO")
public class ToDo implements Serializable{
	
	private static final long serialVersionUID = -7017137550865389720L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
		
	@Column(name = "DESCRIPTION", nullable = false, length=200)
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DUE_DATE")
	private Date dueDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REGISTER_DATE", nullable = false)
	private Date registerDate;
	
	@Column(name = "DONE", nullable = false)
	private boolean done;

	
	public ToDo(){
		super();
	}
	
	
	
	
	public ToDo(Long id, String description, Date dueDate, Date registerDate, boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.registerDate = registerDate;
		this.done = done;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", dueDate=" + dueDate + ", registerDate="
				+ registerDate + ", done=" + done + "]";
	}
	
	
}
