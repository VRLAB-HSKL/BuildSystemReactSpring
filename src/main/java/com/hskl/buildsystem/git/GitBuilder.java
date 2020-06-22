package com.hskl.buildsystem.git;

import com.hskl.buildsystem.unity.UnityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class GitBuilder {

    //the logger
    private final Logger log = LoggerFactory.getLogger(GitBuilder.class);

    @Value("${buildsystem.git.build.cmd}")
    private String cmdBuildGitRepo;

    @Value("${buildsystem.git.status.cmd}")
    private String cmdGitStatus;

    public void cmdCreateGitRepo() {
        Runtime rt = Runtime.getRuntime();
        try{
            Process extractProcess = rt.exec(cmdBuildGitRepo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
