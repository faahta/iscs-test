package com.iscs.test.service;

import com.iscs.test.model.Team;

import java.io.IOException;

/**
 * Created by Fassil on 17/11/20.
 */
public interface FootBallService {
    Team getSmallestGoalDifference() throws IOException;
    String[][] getAllFootBallData() throws IOException;
}
