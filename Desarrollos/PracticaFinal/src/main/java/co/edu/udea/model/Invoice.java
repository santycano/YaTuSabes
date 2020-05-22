package co.edu.udea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Invoice {
	@Id
	@GeneratedValue
	private int id;
	private String fecha;
	private String nit;
	private String invoice;

}
