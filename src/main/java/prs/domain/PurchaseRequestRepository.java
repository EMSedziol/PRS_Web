package prs.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public interface PurchaseRequestRepository extends CrudRepository<PurchaseRequest, Integer> {

}
