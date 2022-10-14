package com.camunda.training;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("paymentRequest")
public class SendPaymentRequestDelegate implements JavaDelegate {

  private static final Logger LOG = LoggerFactory.getLogger(SendPaymentRequestDelegate.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {

  }
}