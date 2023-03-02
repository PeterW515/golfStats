package com.pwgolf.golfStats.workflow.impl;

import com.pwgolf.golfStats.controller.UserController;
import com.pwgolf.golfStats.dto.PlayerAveragesDTO;
import com.pwgolf.golfStats.model.impl.PlayedHole;
import com.pwgolf.golfStats.model.impl.User;
import com.pwgolf.golfStats.workflow.api.PlayerAveragesWorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

@Service
public class PlayerAveragesWorkflowServiceImpl implements PlayerAveragesWorkflowService {
    private final Logger log = LoggerFactory.getLogger(PlayerAveragesWorkflowServiceImpl.class);
    private final UserController userController;

    @Autowired
    public PlayerAveragesWorkflowServiceImpl(UserController userController) {
        this.userController = userController;
    }

    @Override
    public PlayerAveragesDTO findPlayerAverages(Long userId) {
        User currentUser = userController.getUserById(userId);

        if (Objects.nonNull(currentUser) && Objects.nonNull(currentUser.getPlayedHoles())) {
            List<PlayedHole> playedHoles = currentUser.getPlayedHoles();
            double totalHoles = playedHoles.size();
            log.info("total holes: {}", totalHoles);
            double fairwaysHit = playedHoles.stream().filter(PlayedHole::isFairwayInRegulation).count();
            log.info("total fairways: {}", fairwaysHit);

            double greensHit = playedHoles.stream().filter(PlayedHole::isGreenInRegulation).count();
            log.info("total greens: {}", greensHit);

            OptionalDouble putts = playedHoles.stream().mapToInt(PlayedHole::getPutts).average();
            OptionalDouble score = playedHoles.stream().mapToInt(PlayedHole::getScore).average();

            PlayerAveragesDTO playerAveragesDTO = new PlayerAveragesDTO();
            playerAveragesDTO.setAverageFIR(fairwaysHit / totalHoles);
            playerAveragesDTO.setAverageGIR(greensHit / totalHoles);
            playerAveragesDTO.setAveragePutts(putts.getAsDouble());
            playerAveragesDTO.setAverageScore(score.getAsDouble());
            return playerAveragesDTO;
        }
        return null;
    }
}
