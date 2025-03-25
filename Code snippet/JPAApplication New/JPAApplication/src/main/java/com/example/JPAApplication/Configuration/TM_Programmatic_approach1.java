package com.example.JPAApplication.Configuration;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

@Component
public class TM_Programmatic_approach1 {

    PlatformTransactionManager platformTransactionManager;

    public TM_Programmatic_approach1(PlatformTransactionManager platformTransactionManager){
        this.platformTransactionManager = platformTransactionManager;
    }

    public boolean UpdateUser(Runnable transactionalWork){
        TransactionStatus status = platformTransactionManager.getTransaction(null);
        try{
            transactionalWork.run();
            if(true){
                System.out.println("Inside exception");
                throw new Exception("User data is missing!");
            }
            platformTransactionManager.commit(status);
            return true;
        } catch (Exception e){
            platformTransactionManager.rollback(status);
            return false;
        }
    }
}
