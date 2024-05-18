package com.example.kycapp2.controller;

import com.example.kycapp2.entity.ServerLink;
import com.example.kycapp2.service.ServerLinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/serverLink")
public class ServerLinkController {

    private final ServerLinkService serverLinkService;

    public ServerLinkController(ServerLinkService serverLinkService) {
        this.serverLinkService = serverLinkService;
    }

    @PutMapping("/{id}")
    ResponseEntity<ServerLink> updateServerLink(@PathVariable String id, @RequestBody String serverLink){
   ServerLink updatedServerLink = serverLinkService.updateServerLink(id,serverLink);
    return ResponseEntity.ok(updatedServerLink);
}
    @GetMapping("/{id}")
    ResponseEntity<String> getServerLink(@PathVariable String id){
        String link = serverLinkService.getServerLink(id);
        return ResponseEntity.ok(link);
    }
}
