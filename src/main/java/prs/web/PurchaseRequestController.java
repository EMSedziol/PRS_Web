package prs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.PurchaseRequest;
import prs.domain.PurchaseRequestRepository;
import prs.domain.PurchaseRequest;

@Controller
@RequestMapping(path="/PR")
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaserequestRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequest> getAllPRs() {
		return purchaserequestRepository.findAll();
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody PurchaseRequest addNewPurchaseRequest (@RequestBody PurchaseRequest purchaseRequest) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
		// 
		// http://localhost:8080/PurchaseRequest/Add  - used in Postman
		//
        purchaserequestRepository.save(purchaseRequest);
        System.out.println("PurchaseRequest saved:  "+purchaseRequest);
        return purchaseRequest;
	}
}
