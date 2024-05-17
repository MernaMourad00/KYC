package com.example.kycapp2.service.serviceImpl;

import com.example.kycapp2.entity.ServerLink;
import com.example.kycapp2.repository.ServerLinkRepository;
import com.example.kycapp2.service.ServerLinkService;
import org.springframework.stereotype.Service;

@Service
public class ServerLinkServiceImpl implements ServerLinkService {

    private final ServerLinkRepository serverLinkRepository;

    public ServerLinkServiceImpl(ServerLinkRepository serverLinkRepository) {
        this.serverLinkRepository = serverLinkRepository;
    }


    @Override
    public ServerLink updateServerLink(String id, String newLink) {
        ServerLink serverLink = serverLinkRepository.findById(id)
                .orElse(new ServerLink(id, newLink));
        serverLink.setLink(newLink);
        return serverLinkRepository.save(serverLink);    }

    @Override
    public String getServerLink(String id) {
        return serverLinkRepository.findById(id)
                .map(ServerLink::getLink)
                .orElse(null);
    }
}
