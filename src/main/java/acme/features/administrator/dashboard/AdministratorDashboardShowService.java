
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.List;

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


		request.unbind(entity, model, "countAnnouncement", "countCompanyRecords", "countInvestorRecords", "minActiveRequest", "maxActiveRequest", "avgActiveRequest", "stDerivationActiveRequest", "minActiveOffer", "maxActiveOffer", "avgActiveOffer",
			"stDerivationActiveOffer", "numSectorbyCompany", "sectorsbyCompany");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		result.setCountAnnouncement(this.repository.countAnnouncement());
		result.setCountCompanyRecords(this.repository.countCompanyRecord());
		result.setCountInvestorRecords(this.repository.countInvestorRecords());

		result.setMinActiveRequest(this.repository.minMaxAvgStDerivationActiveRequest().get(0));
		/*
		 * result.setMaxActiveRequest(this.repository.minMaxAvgStDerivationActiveRequest().get(1));
		 * result.setAvgActiveRequest(this.repository.minMaxAvgStDerivationActiveRequest().get(2));
		 * result.setStDerivationActiveRequest(this.repository.minMaxAvgStDerivationActiveRequest().get(3));
		 */
		result.setMinActiveOffer(this.repository.minMaxAvgStDerivationActiveOffer().get(0));
		/*
		 * result.setMaxActiveOffer(this.repository.minMaxAvgStDerivationActiveOffer().get(1));
		 * result.setAvgActiveOffer(this.repository.minMaxAvgStDerivationActiveOffer().get(2));
		 * result.setStDerivationActiveOffer(this.repository.minMaxAvgStDerivationActiveOffer().get(3));
		 */

		Object[] sectores = this.repository.sectores();

		List<Integer> n = new ArrayList<Integer>();
		List<String> s = new ArrayList<String>();

		int i = 0;
		while (i < sectores.length) {
			Object[] x = (Object[]) sectores[i];
			n.add(Integer.parseInt(x[1].toString()));
			s.add(x[0].toString());
			i++;
		}

		result.setNumSectorbyCompany(n);
		result.setSectorsbyCompany(s);
    
		return result;
	}
}
