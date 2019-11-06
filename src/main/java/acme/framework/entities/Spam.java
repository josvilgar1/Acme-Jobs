
package acme.framework.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@ElementCollection(fetch = FetchType.EAGER)
	@NotEmpty
	private List<String>		words;

	@Digits(integer = 3, fraction = 2)
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	@NotNull
	private BigDecimal			threshold;

}
