package com.iscs.test.service.impl;

import com.iscs.test.model.Team;
import com.iscs.test.service.FootBallService;
import com.iscs.test.util.ReadBinaryFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fassil on 17/11/20.
 */
@Service
public class FootBallServiceImpl implements FootBallService {
    private static final Logger logger = LogManager.getLogger(FootBallServiceImpl.class);
    private static final String FILE_NAME = "football.dat";
    @Override
    public Team getSmallestGoalDifference() throws IOException {
        List<Integer> result = new ArrayList<>();
        Integer minRange=900;

        Team team=null;
        Path path = FileSystems.getDefault().getPath(FILE_NAME);
        String[][] footBallData = ReadBinaryFile.read(path);
        for (int i = 0; i < footBallData.length; i++) {
            for (int j = 0; j < footBallData[i].length; j++) {
                System.out.print(footBallData[i][j] + " ");
                if(j==6){
                    /*calcolare la differenza tra i goal segnati e subiti (le colone 6 e 8 rispettivamente)*/
                    Integer diff = Integer.parseInt(footBallData[i][j]) - Integer.parseInt(footBallData[i][j+2]);
                    result.add(diff);
                    if(minRange>diff) {
                        /*il minimo attuale è trovato, costruire l'oggeto Team*/
                        team = new Team(footBallData[i][0], footBallData[i][1], footBallData[i][2], footBallData[i][3], footBallData[i][3], footBallData[i][4],
                                footBallData[i][5], footBallData[i][6], footBallData[i][8]);

                    }
                }
            }
            System.out.println();
        }
        logger.info(team.toString());
        return team;
    }

    @Override
    public String[][] getAllFootBallData() throws IOException {
        Path path = FileSystems.getDefault().getPath(FILE_NAME);
        return ReadBinaryFile.read(path);
    }
}
