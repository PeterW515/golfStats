package com.pwgolf.golfStats.controller;

import com.pwgolf.golfStats.dto.PlayerAveragesDTO;
import com.pwgolf.golfStats.workflow.api.PlayerAveragesWorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlayerAveragesController {
    private final Logger log = LoggerFactory.getLogger(PlayerAveragesController.class);

    private PlayerAveragesWorkflowService playerAveragesWorkflowService;

    @Autowired
    public PlayerAveragesController(PlayerAveragesWorkflowService playerAveragesWorkflowService) {
        this.playerAveragesWorkflowService = playerAveragesWorkflowService;
    }

    @GetMapping("playerAverages/{id}")
    ResponseEntity<PlayerAveragesDTO> getPlayerAverages(@PathVariable Long id) {
        PlayerAveragesDTO playerAveragesDTO = playerAveragesWorkflowService.findPlayerAverages(id);

        return ResponseEntity.ok().body(playerAveragesDTO);
    }
}
