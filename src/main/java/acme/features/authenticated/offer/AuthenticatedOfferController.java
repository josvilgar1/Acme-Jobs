
package acme.features.authenticated.offer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.offers.Offer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/offer")
public class AuthenticatedOfferController extends AbstractController<Authenticated, Offer> {

	@Autowired
	private AuthenticatedOfferListService			listService;

	@Autowired
	private AuthenticatedOfferListAllActiveService	listAllActiveService;

	@Autowired
	private AuthenticatedOfferShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_ALL_ACTIVE, BasicCommand.LIST, this.listAllActiveService);
	}

}
