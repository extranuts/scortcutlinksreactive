package com.example.scortcutlinksreactive;


import com.example.scortcutlinksreactive.common.ShortLink;
import com.example.scortcutlinksreactive.links.LinksService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Queue;

/**
 * @author
 * @return
 */

@Component
@EnableScheduling
public class LinkJob {

    private final Queue<String> linksQueue;
    private final LinksService linksService;

    public LinkJob(Queue<String> linksQueue, LinksService linksService) {
        this.linksQueue = linksQueue;
        this.linksService = linksService;
    }

    @Scheduled(fixedRate = 1000L)
    public void freeLink() {

        linksService.randomPull().doOnSuccess(shortLink -> {
            if (shortLink != null) {
                linksService.remove(shortLink.getCode());
                linksQueue.add(shortLink.getCode());
            }
        }).subscribe(System.out::println);
    }

    @Scheduled(fixedRate = 500L)
    public void bookLink() {
        String code = linksQueue.poll();
        if(code!= null) {
            linksService.save(new ShortLink(code, "gmail.com"));
        }
    }

    @Scheduled(fixedRate = 500L)
    public void useLink() {
        linksService.randomPull().subscribe(System.out::println);
    }
}

























