package com.example.scortcutlinksreactive.links;


import com.example.scortcutlinksreactive.common.ShortLink;
import reactor.core.publisher.Mono;

/**
 * @author
 * @return
 */


public interface LinksService {

    void save(ShortLink link);

    void remove(String code);

    Mono<ShortLink> get(Mono<String> code);

    Mono<ShortLink> randomPull();

    Mono<String> randomKey();


}
