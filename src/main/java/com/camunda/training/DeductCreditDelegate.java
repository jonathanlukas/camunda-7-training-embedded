package com.camunda.training;

import com.camunda.training.services.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("deductCredit")
public class DeductCreditDelegate implements JavaDelegate {
  private final CustomerService service;

  @Autowired
  public DeductCreditDelegate(CustomerService service) {
    this.service = service;
  }

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    // extract variables from process instance
    String customerId = (String) execution.getVariable("customerId");
    Double amount = (Double) execution.getVariable("orderTotal");
    // execute business logic using the variables
    Double openAmount = service.deductCredit(customerId, amount);
    Double customerCredit = service.getCustomerCredit(customerId);
    // save the results to the process instance
    execution.setVariable("openAmount", openAmount);
    execution.setVariable("customerCredit", customerCredit);
  }
}