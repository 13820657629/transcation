package org.example.transcation.example2;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author weishitong
 * @date 2025/3/26 16:54
 */
public class Service {

    @Resource
    private TransactionTemplate transactionTemplate;

    public void ServiceFunction() {
        transactionTemplate.execute(status -> {
            // 数据库操作;

            // 事务完成后发送消息
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    //发送消息代码;
                }
            });
            return null;
        });
    }
}
