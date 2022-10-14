package com.camunda.training;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.process_test_coverage.junit5.ProcessEngineCoverageExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(ProcessEngineCoverageExtension.class)
public class ProcessJUnitTest {
  
  @Test
  @Deployment(resources = "payment_process.bpmn")
  public void testHappyPath() {
    // Create a HashMap to put in variables for the process instance
    Map<String, Object> variables = new HashMap<String, Object>();
    variables.put("orderTotal", 30.00);
    variables.put("customerCredit", 20.00);
    // Start process with Java API and variables
    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("PaymentProcess", variables);
    // Make assertions on the process instance
    assertThat(processInstance).isEnded().hasPassed("Activity_Charge_Credit_Card");
  }

}
