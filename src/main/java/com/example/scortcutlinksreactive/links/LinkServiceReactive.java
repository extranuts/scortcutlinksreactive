package com.example.scortcutlinksreactive.links;


import com.example.scortcutlinksreactive.common.ShortLink;
import reactor.core.publisher.Mono;

/**
 * @author
 * @return
 */


public class LinkServiceReactive implements LinksService{




    @Override
    public void save(ShortLink link) {

    }

    @Override
    public void remove(String code) {

    }

    @Override
    public Mono<ShortLink> get(Mono<String> code) {
        return null;
    }

    @Override
    public Mono<ShortLink> randomPull() {
        return null;
    }

    @Override
    public Mono<String> randomKey() {
        return null;
    }
}
