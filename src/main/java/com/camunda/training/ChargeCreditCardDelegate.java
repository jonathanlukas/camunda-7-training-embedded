package com.camunda.training;

import com.camunda.training.services.CreditCardService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("chargeCreditCard")
public class ChargeCreditCardDelegate implements JavaDelegate {
  private final CreditCardService creditCardService;

  @Autowired
  public ChargeCreditCardDelegate(CreditCardService creditCardService) {
    this.creditCardService = creditCardService;
  }

  @Override
  public void execute(DelegateExecution execution) {
    // extract variables from process instance
    String cardNumber = (String) execution.getVariable("cardNumber");
    String cvc = (String) execution.getVariable("CVC");
    String expiryData = (String) execution.getVariable("expiryDate");
    Double amount = (Double) execution.getVariable("openAmount");
    // execute business logic using the variables
    if (cvc.equals("789")) {
      throw new RuntimeException("CVC invalid!");
    }
    try {
      creditCardService.chargeAmount(cardNumber, cvc, expiryData, amount);
    } catch (Exception exc) {
      throw new BpmnError("chargingError", "We failed to charge credit card with card number " + cardNumber, exc);
    }
  }
}