package com.hskl.buildsystem.service;

import com.hskl.buildsystem.git.GitBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitService {

    @Autowired
    GitBuilder gitBuilder;

    @GetMapping("/api/git/create")
    public void createGitRepo() {
        gitBuilder.cmdCreateGitRepo();

    }

    @GetMapping("/api/git/status")
    public  void  gitStatus() {
        gitBuilder.cmdGitStatus();
    }
}
