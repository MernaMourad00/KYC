package com.example.kycapp2.service;

import com.example.kycapp2.entity.ServerLink;
import org.springframework.stereotype.Service;

@Service
public interface ServerLinkService {
    ServerLink updateServerLink(String id, String newLink);
    String getServerLink(String id);

}
