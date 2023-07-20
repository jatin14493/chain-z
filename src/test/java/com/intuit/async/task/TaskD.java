package com.intuit.async.task;

import com.intuit.async.execution.Task;
import com.intuit.async.execution.request.State;

import lombok.extern.slf4j.Slf4j;

/** @author Nishant-Sehgal */
@Slf4j
public class TaskD implements Task {

  private String requestKey;
  private String responseKey;
  private String response;

  public TaskD(String requestKey, String responseKey, String response) {
    this.requestKey = requestKey;
    this.responseKey = responseKey;
    this.response = response;
  }

  @Override
  public State execute(State inputRequest) {
	  log.info(
        "Start Request Key TaskD :: "
            + inputRequest.getValue(requestKey)
            + "  Thread :: "
            + Thread.currentThread().getName());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    log.info(
        "Complete TaskD:: "
            + inputRequest.getValue(requestKey)
            + "  Thread :: "
            + Thread.currentThread().getName());
    inputRequest.addValue(responseKey, response);
    return inputRequest;
  }
}
