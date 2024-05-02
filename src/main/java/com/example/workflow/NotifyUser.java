package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class NotifyUser implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if((Boolean) delegateExecution.getVariable("decision")) {
            System.out.printf("%s! Ваша заявка на отпуск одобрена",
                    delegateExecution.getVariable("name"));
        } else {
            System.out.printf("%s, Ваша заявка на отпуск, к сожалению, отклонена",
                    delegateExecution.getVariable("name"));
        }
    }
}
