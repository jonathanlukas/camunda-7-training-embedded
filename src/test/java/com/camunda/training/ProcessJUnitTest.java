package com.camunda.training;

import org.camunda.bpm.engine.test.Deployment;
import org.junit.jupiter.api.Test;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.assertj.core.api.Assertions.*;
public class ProcessJUnitTest {
  
  @Test
  @Deployment(resources = "payment_process.bpmn")
  public void testHappyPath() {
    
  }

}
