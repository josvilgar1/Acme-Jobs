
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "countAnnouncement", "countCompanyRecords", "countInvestorRecords", "minActiveRequest", "maxActiveRequest", "avgActiveRequest", "stDerivationActiveRequest", "minRangeMinActiveOffer", "maxRangeMinActiveOffer",
			"avgRangeMinActiveOffer", "stDerivationRangeMinActiveOffer", "minRangeMaxActiveOffer", "maxRangeMaxActiveOffer", "avgRangeMaxActiveOffer", "stDerivationRangeMaxActiveOffer");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		result.setCountAnnouncement(this.repository.countAnnouncement());
		result.setCountCompanyRecords(this.repository.countCompanyRecord());
		result.setCountInvestorRecords(this.repository.countInvestorRecords());

		result.setMinActiveRequest(this.repository.minActiveRequest());
		result.setMaxActiveRequest(this.repository.maxActiveRequest());
		result.setAvgActiveRequest(this.repository.avgActiveRequest());
		result.setStDerivationActiveRequest(this.repository.stDerivationActiveRequest());

		result.setMinRangeMinActiveOffer(this.repository.minRangeMinActiveOffer());
		result.setMaxRangeMinActiveOffer(this.repository.maxRangeMinActiveOffer());
		result.setAvgRangeMinActiveOffer(this.repository.avgRangeMinActiveOffer());
		result.setStDerivationRangeMinActiveOffer(this.repository.stDerivationRangeMinActiveOffer());

		result.setMinRangeMaxActiveOffer(this.repository.minRangeMaxActiveOffer());
		result.setMaxRangeMaxActiveOffer(this.repository.maxRangeMaxActiveOffer());
		result.setAvgRangeMaxActiveOffer(this.repository.avgRangeMaxActiveOffer());
		result.setStDerivationRangeMaxActiveOffer(this.repository.stDerivationRangeMaxActiveOffer());

		return result;
	}
}
