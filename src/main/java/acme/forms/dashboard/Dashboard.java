
package acme.forms.dashboard;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						countAnnouncement;
	Integer						countCompanyRecords;
	Integer						countInvestorRecords;
	Double						minActiveRequest;
	Double						maxActiveRequest;
	Double						avgActiveRequest;
	Double						stDerivationActiveRequest;
	Double						minActiveOffer;
	Double						maxActiveOffer;
	Double						avgActiveOffer;
	Double						stDerivationActiveOffer;
}
