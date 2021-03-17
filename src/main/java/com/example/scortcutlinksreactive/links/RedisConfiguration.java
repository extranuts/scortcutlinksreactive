package com.example.scortcutlinksreactive.links;


import com.example.scortcutlinksreactive.common.ShortLink;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author
 * @return
 */

@Configuration
public class RedisConfiguration {

    ReactiveRedisOperations<String, ShortLink> redisOperations(ReactiveRedisConnectionFactory factory){

        RedisSerializationContext.RedisSerializationContextBuilder<String, ShortLink> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        builder.value(new Jackson2JsonRedisSerializer<ShortLink>(ShortLink.class));

        RedisSerializationContext<String,ShortLink> context =builder.build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
