package com.g7.framework.generator.reactive.config;

import com.g7.framework.generator.reactive.DefaultUidGenerator;
import com.g7.framework.generator.reactive.worker.DisposableWorkerIdAssigner;
import com.g7.framework.redis.reactive.ReactiveRedisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

/**
 * @author dreamyao
 * @title
 * @date 2018/11/1 10:28 AM
 * @since 1.0.0
 */
@AutoConfiguration
@AutoConfigureAfter(value = ReactiveRedisAutoConfiguration.class)
public class GeneratorAutoConfiguration {

    @Bean
    @ConditionalOnBean(value = ReactiveRedisTemplate.class)
    public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
        return new DisposableWorkerIdAssigner();
    }

    @Bean
    @ConditionalOnBean(value = {ReactiveRedisTemplate.class,DisposableWorkerIdAssigner.class})
    public DefaultUidGenerator cachedUidGenerator(@Autowired DisposableWorkerIdAssigner disposableWorkerIdAssigner) {
        DefaultUidGenerator generator = new DefaultUidGenerator();
        // 用完即弃的WorkerIdAssigner, 依赖Redis操作
        generator.setWorkerIdAssigner(disposableWorkerIdAssigner);

        generator.setTimeBits(28);
        generator.setWorkerBits(22);
        generator.setSeqBits(13);
        generator.setEpochStr("2020-01-20");

        return generator;
    }
}
