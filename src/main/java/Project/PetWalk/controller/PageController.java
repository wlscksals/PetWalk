package Project.PetWalk.controller;

import Project.PetWalk.dto.PostDto;
import Project.PetWalk.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page")
@Slf4j
public class PageController {
    private final PostService postService;
    @GetMapping("/post/dto")
    public String postDto() {
        return "PostTest";
    }

    @PostMapping("/post/dto/test")
    public String postTest(@ModelAttribute PostDto postDto, Model model) {
        postService.writePost(postDto);
        log.info("{}", postDto);
        model.addAttribute("dto", postDto);
        return "PostDtoPage";
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<PostDto> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "Main";
    }
}
