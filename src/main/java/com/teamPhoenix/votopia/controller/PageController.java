package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.entity.User;
import com.teamPhoenix.votopia.service.VoterIdentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final VoterIdentificationService voterIdentificationService;
    @GetMapping("/")
    public String home(Model model, Authentication authentication, @AuthenticationPrincipal User userDetails) {
        model.addAttribute("user", userDetails);
        return "index";
    }
    @GetMapping("/voter-identification")
    public String loadVoterIdentificationPage(){
        return "voter-identification";
    }

    @GetMapping("/election")
    public String loadStartVotingSessionPage(){
        return "election";
    }

    @GetMapping("/election/create")
    public String loadCreateElectionPage(){
        return "create-election";
    }
    @GetMapping("/post")
    public String loadCreatePostPage(){
        return "create-post";
    }


}
