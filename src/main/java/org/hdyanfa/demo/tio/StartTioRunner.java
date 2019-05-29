package org.hdyanfa.demo.tio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xiaochai
 * @create: 2019-04-11
 **/
@Component
public class StartTioRunner implements CommandLineRunner {

    @Resource
    private TioWsMsgHandler tioWsMsgHandler;

    private TioWebsocketStarter appStarter;

    @Override
    public void run(String... args) throws Exception {
        this.appStarter = new TioWebsocketStarter(TioServerConfig.SERVER_PORT, tioWsMsgHandler);
        appStarter.getWsServerStarter().start();
    }
}
