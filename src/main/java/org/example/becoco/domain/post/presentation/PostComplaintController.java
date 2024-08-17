package org.example.becoco.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.presentation.dto.request.ComplaintStatusRequest;
import org.example.becoco.domain.post.presentation.dto.request.PostCreateRequest;
import org.example.becoco.domain.post.presentation.dto.response.PostResponse;
import org.example.becoco.domain.post.presentation.dto.request.PostUpdateRequest;
import org.example.becoco.domain.post.service.Complaint.ComplaintCreateService;
import org.example.becoco.domain.post.service.Complaint.ComplaintStatusService;
import org.example.becoco.domain.post.service.PostDeleteService;
import org.example.becoco.domain.post.service.PostUpdateService;
import org.example.becoco.domain.post.service.PostViewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post/complaint")
public class PostComplaintController {
    private final ComplaintCreateService createService;
    private final PostUpdateService updateService;
    private final PostDeleteService deleteService;
    private final PostViewService viewService;
    private final ComplaintStatusService statusService;

    @PostMapping("/write")
    private void postWrite(@RequestBody PostCreateRequest request) {
        createService.postCreate(request);
    }

    @DeleteMapping("/{id}")
    private void postDelete(@PathVariable("id") Long id) {
        deleteService.postDelete(id);
    }

    @GetMapping("/{id}")
    private PostResponse postView(@PathVariable("id") Long id) {
        return viewService.postView(id);
    }

    @PatchMapping("/{id}")
    private void postUpdate(@PathVariable("id") Long id, @RequestBody PostUpdateRequest request) {
        updateService.updatePost(id, request);
    }

    @PatchMapping("/status/{id}")
    private void complaintStatus(@PathVariable("id") Long id, @RequestBody ComplaintStatusRequest request) {
        statusService.statusChange(id, request);
    }
}