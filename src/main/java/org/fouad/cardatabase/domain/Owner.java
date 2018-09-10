package org.fouad.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Owner {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ownerid;
    private String firstname;
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;
    
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
 
    
}
