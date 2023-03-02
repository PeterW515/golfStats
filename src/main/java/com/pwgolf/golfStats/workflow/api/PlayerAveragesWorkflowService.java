package com.pwgolf.golfStats.workflow.api;

import com.pwgolf.golfStats.dto.PlayerAveragesDTO;

public interface PlayerAveragesWorkflowService {

    PlayerAveragesDTO findPlayerAverages(Long userId);
}
