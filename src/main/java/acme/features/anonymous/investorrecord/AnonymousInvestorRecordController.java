
package acme.features.anonymous.investorrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/investorrecord/")
public class AnonymousInvestorRecordController extends AbstractController<Anonymous, Investorrecord> {

	//Internal State	----------------------------------------

	@Autowired
	private AnonymousInvestorRecordListService	listService;

	@Autowired
	private AnonymousInvestorRecordShowService	showService;


	//Constructors 	--------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
