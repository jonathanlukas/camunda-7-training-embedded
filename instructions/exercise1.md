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

## Run a process instance

Go to `localhost:8080` and login using demo/demo.

Then, go to Tasklist and click on **Start Process** in the top right corner.

Select the _Pay Invoice_ and add a process variable in the next dialog:

Name: `creditSufficient`, type **Boolean**, choose the value you prefer.

After this is done, go to the Cockpit using the App Switcher in the top right corner.

Click on **Processes** in the top bar and select _History View_ of the _Pay Invoice_ in the list.

There should be one process instance in the list on the bottom right. Inspect its activity history and variables. Is the result expected?
