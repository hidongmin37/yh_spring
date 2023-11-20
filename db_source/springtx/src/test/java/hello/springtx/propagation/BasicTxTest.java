package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;
@Slf4j
@SpringBootTest
public class BasicTxTest {


    @Autowired
    PlatformTransactionManager pmTxManager;

    @TestConfiguration
    static class Config {

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

    }

    @Test
    void commit(){
        log.info("트랜잭션 시작");
        TransactionStatus status = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋 시작");

        pmTxManager.commit(status);
        log.info("트랜잭션 커밋 완료");
    }

    @Test
    void rollback(){
        log.info("트랜잭션 시작");
        TransactionStatus status = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 롤백 시작");

        pmTxManager.rollback(status);
        log.info("트랜잭션 롤백 완료");
    }

    @Test
    void double_commit() {
        log.info("트랜잭션1 시작");
        TransactionStatus tx1 = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션1 커밋 시작");
        pmTxManager.commit(tx1);



        log.info("트랜잭션2 시작");
        TransactionStatus tx2 = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션2 커밋 시작");
        pmTxManager.commit(tx2);


    }

    @Test
    void inner_commit() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = pmTxManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={} ", outer.isNewTransaction()); //true

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = pmTxManager.getTransaction(new DefaultTransactionAttribute());
        log.info("inner.isNewTransaction()={}", inner.isNewTransaction()); //false

        log.info("내부 트랜잭션 커밋");
        pmTxManager.commit(inner);

        log.info("외부 트랜잭션 커밋");
        pmTxManager.commit(outer);

    }

    @Test
    void outer_rollback() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("내부 트랜잭션 커밋");
        pmTxManager.commit(inner);

        log.info("외부 트랜잭션 롤백");
        pmTxManager.rollback(outer);
    }

    @Test
    void inner_rollback() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = pmTxManager.getTransaction(new DefaultTransactionAttribute());

        log.info("내부 트랜잭션 롤백");
        pmTxManager.rollback(inner); //rollback-only 표시

        log.info("외부 트랜잭션 커밋");
//        pmTxManager.commit(outer);
        Assertions.assertThatThrownBy(() -> pmTxManager.commit(outer))
                .isInstanceOf(UnexpectedRollbackException.class);
    }

    @Test
    void inner_rollback_requires_new() {
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = pmTxManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus inner = pmTxManager.getTransaction(definition);
        log.info("outer.isNewTransaction()={}", inner.isNewTransaction());

        log.info("내부 트랜잭션 롤백");
        pmTxManager.rollback(inner);

        log.info("외부 트랜잭션 커밋");
        pmTxManager.commit(outer);
    }


}
