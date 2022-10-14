package com.camunda.training;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("paymentCompletion")
public class SendPaymentCompletionDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    execution
        .getProcessEngineServices()
        .getRuntimeService()
        .createMessageCorrelation("paymentCompletedMessage")
        .processInstanceBusinessKey(execution.getProcessBusinessKey())
        .correlate();
  }
}