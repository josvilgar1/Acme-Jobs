
package acme.entities.investorrecords;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Investorrecord extends DomainEntity {

	//	Serialisation identifier --------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Attributes	---------------------------------------------

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				statement;

	@Min(1)
	@Max(5)
	@Range
	private Integer				stars;

}
