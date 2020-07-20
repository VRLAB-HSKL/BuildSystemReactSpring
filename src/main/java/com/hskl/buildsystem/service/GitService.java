package com.hskl.buildsystem.service;

import com.hskl.buildsystem.git.GitBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides the approach to git management.
 * But is currently not used and is available for further development
 */
@RestController
public class GitService {

    //GitBuilder
    @Autowired
    private GitBuilder gitBuilder;

    /**
     * create git repo
     */
    @GetMapping("/api/git/create")
    public void createGitRepo() {
        gitBuilder.cmdCreateGitRepo();

    }

    /**
     * Return GIT Status
     */
    @GetMapping("/api/git/status")
    public  void  gitStatus() {
        gitBuilder.cmdGitStatus();
    }
}
