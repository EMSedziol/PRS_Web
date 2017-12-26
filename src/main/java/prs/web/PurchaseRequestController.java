package prs.web;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import prs.domain.*;

@Controller
@RequestMapping(path="/PR")
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaserequestRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequest> getAllPRs() {
		return purchaserequestRepository.findAll();
	}
	
	@PostMapping(path="/Add") // Map ONLY GET Requests
	public @ResponseBody PurchaseRequest addNewPurchaseRequest (@RequestBody PurchaseRequest purchaseRequest) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		// submittedDate cannot be null so setting here as initial submit date.
		//   per business rules we will need to re-set this when line items are done.
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		purchaseRequest.setSubmittedDate(ts);
		purchaserequestRepository.save(purchaseRequest);
		System.out.println("PurchaseRequest saved:  "+purchaseRequest);
		return purchaseRequest;
	}
	
	@GetMapping(path="/Remove") // Map ONLY GET Requests
	public @ResponseBody PurchaseRequest deletePurchaseRequest (@RequestParam int id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		PurchaseRequest purchaseRequestLineItem = purchaserequestRepository.findOne(id);
		purchaserequestRepository.delete(purchaseRequestLineItem);
		return purchaseRequestLineItem;
	}
}
