package com.hskl.buildsystem.unity;

import com.hskl.buildsystem.service.UnityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class UnityBuilder {

    @Value("${buildsystem.unity.path}")
    private String unityInstallPath;

    @Value("${buildsystem.unity.param}")
    private String unityParams;

    @Value("${buildsystem.unity.test.path}")
    private String destination;

    @Value("${buildsystem.unity.cmd}")
    private String cmd;

    //the logger
    private final Logger log = LoggerFactory.getLogger(UnityBuilder.class);

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
