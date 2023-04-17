# Run the prototype

## Start the Spring Boot Application

Download the Spring Boot Application from the `ex1` tag and run it (using `mvn spring-boot:run` or your IDE).

## Add history time to live

In the properties of the process, expand _History Cleanup_ and set the _Time to Live_ to `30`.

This means that the historical data of the process should be kept for 30 days.

## Add expressions to sequence flows

For ease, the XOR-Gateway will only evaluate a simple boolean expression.

To achieve this, we will put these expressions on the outgoing sequence flows:

`${creditSufficient}` on the sequence flow with _yes_.

`${not creditSufficient}` on the sequence flow with _no_.

Save the progress and deploy the process model with the rocket ship button.
