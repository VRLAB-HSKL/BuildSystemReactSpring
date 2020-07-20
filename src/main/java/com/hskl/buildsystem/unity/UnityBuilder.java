package com.hskl.buildsystem.unity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class creates a new Unity project using a python script
 */
@Component
public class UnityBuilder {

    //path to unity execution file
    @Value("${buildsystem.unity.path}")
    private String unityInstallPath;

    //unity param means unity started and quit silent
    @Value("${buildsystem.unity.param}")
    private String unityParams;

    //destination path
    @Value("${buildsystem.unity.test.path}")
    private String destination;

    //cmd command to execute
    @Value("${buildsystem.unity.cmd}")
    private String cmd;

    //the logger
    private final Logger log = LoggerFactory.getLogger(UnityBuilder.class);

    /**
     * this method calls via the application runtime a python script which build a new unity project
     */
    public void createUnityProject() {
        Runtime rt = Runtime.getRuntime();

        String path = cmd + " " + unityInstallPath +" "+ unityParams +" "+ destination;
        log.info(path);

        String path2 = "python G:\\MasterThesis-Dev\\Workspace\\BuildSystemReactSpring\\src\\main\\resources\\python\\CreateUnityProject.py";
        try{
            Process extractProcess = rt.exec(cmd);
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
