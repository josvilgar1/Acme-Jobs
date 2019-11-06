
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

		result.setMinActiveRequest(this.repository.queryActiveRequest()[0][0]);
		result.setMaxActiveRequest(this.repository.queryActiveRequest()[0][1]);
		result.setAvgActiveRequest(this.repository.queryActiveRequest()[0][2]);
		result.setStDerivationActiveRequest(this.repository.queryActiveRequest()[0][3]);

		result.setMinRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer()[0][0]);
		result.setMaxRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer()[0][1]);
		result.setAvgRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer()[0][2]);
		result.setStDerivationRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer()[0][3]);

		result.setMinRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer()[0][0]);
		result.setMaxRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer()[0][1]);
		result.setAvgRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer()[0][2]);
		result.setStDerivationRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer()[0][3]);

		return result;
	}
}
