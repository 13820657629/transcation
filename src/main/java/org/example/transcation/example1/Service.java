package org.example.transcation.example1;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author weishitong
 * @date 2025/3/26 16:45
 */
@Data
public class Service {

    @Transactional(rollbackFor = Exception.class)
    public void ServiceFunction() {
        //操作数据库的代码

        TransactionSynchronizationManager.registerSynchronization(
                new TransactionSynchronization() {
                    @Override
                    public void afterCommit() {
                        // 发送消息代码
                    }
                }
        );
    }

}
