# Handle an exception

## Goal

In this lab, you will throw an exception and then refactor the process to handle this as an incident. You will also test the behaviour

## Short description

* Mock an error in the service call towards the credit card service, throw an exception
* adjust the process model to handle the charge credit card in a new transaction
* create another test to explicitly test the error behaviour
* adjust the other test so that they still work

## Detailed steps

1. Adjust the `ChargeCreditCardDelegate`. Insert this block after fetching all variables:
    ```java
    if (cvc.equals("789")) {
      throw new RuntimeException("CVC invalid!");
    }
    ```
2. In the process model, select service task **charge credit card** and tick `Asynchronous continuations > Before`.
3. Insert another test in the unit test class:
    ```java
    @Test
    @Deployment(resources = "payment_process.bpmn")
    public void testInvalidCVC(){
      Mocks.register("paymentCompletion", (JavaDelegate) execution -> {});
      // Create a HashMap to put in variables for the process instance
      Map<String, Object> variables = new HashMap<String, Object>();
      variables.put("orderTotal", 30.00);
      variables.put("customerId", "cust20");
      variables.put("cardNumber", "1234 5678");
      variables.put("CVC", "789");
      variables.put("expiryDate", "09/24");
      // Start process with Java API and variables
      ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("PaymentProcess", variables);
      // try to execute credit card payment
      assertThat(processInstance).isWaitingAt("Activity_Charge_Credit_Card");
      RuntimeException exception = assertThrows(RuntimeException.class, () -> execute(job()));
      Assertions.assertThat(exception).hasMessage("CVC invalid!");
    }
    ```
4. Run only this test. This should work.
5. Run all tests. Some of them fail. Why?