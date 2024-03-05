package mp.CarDatabaseWeek6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Car {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "car's brand cannot be empty.")
    @Size(min = 3, max = 250)
	private String brand;
	
	private String model;
	private String color; 
	
	@Column(name ="register_number")
	private String registerNumber;
	private double price;

	@Column(name = "production_year")
	private int year;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ownerid")
	private Owner owner;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Car(@NotEmpty(message = "car's brand cannot be empty.") @Size(min = 3, max = 250) String brand, String model,
			String color, String registerNumber, double price, int year, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.price = price;
		this.year = year;
		this.owner = owner;
	}



	public Car(String brand, String model, String color, String registerNumber, double price, int year) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.price = price;
		this.year = year;
	}
	
	

	public Car(String brand,String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public Owner getOwner() {
		return owner;
	}



	public void setOwner(Owner owner) {
		this.owner = owner;
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", color=" + color + ", registerNumber="
				+ registerNumber + ", price=" + price + ", year=" + year + ", owner=" + owner + "]";
	}

	


}
