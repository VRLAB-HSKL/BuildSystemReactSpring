package com.hskl.buildsystem.git;

import com.hskl.buildsystem.unity.UnityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class can later be used for administration by git.
 * It is currently able to output the project structure of the Git-Hub organization HS-KL.
 *
 * actually not needed
 */
@Component
public class GitBuilder {

    //the logger
    private final Logger log = LoggerFactory.getLogger(GitBuilder.class);

    //path to python file to create a git repo
    @Value("${buildsystem.git.build.cmd}")
    private String cmdBuildGitRepo;

    //path to python file to check git status
    @Value("${buildsystem.git.status.cmd}")
    private String cmdGitStatus;

    /**
     * execute python script to generate a git repo. Method actually not completely implemented.
     * Needed for further development
     */
    public void cmdCreateGitRepo() {
        Runtime rt = Runtime.getRuntime();
        try{
            Process extractProcess = rt.exec(cmdBuildGitRepo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Displays the folder and project structure of the HS-KL organization
     */
    public void cmdGitStatus() {
        Runtime rt = Runtime.getRuntime();
        try{
            Process extractProcess = rt.exec(cmdGitStatus);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(extractProcess.getInputStream()));
            StringBuilder buffer = new StringBuilder();
            String line = null;
            while ((line = bfr.readLine()) != null){
                buffer.append(line);
            }
            log.info("output: "+buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
