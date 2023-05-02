package com.UST.InterviewFeedback.controller.impl;

import com.UST.InterviewFeedback.controller.InterviewFeedbackController;
import com.UST.InterviewFeedback.dto.InterviewFeedbackDTO;
import com.UST.InterviewFeedback.entity.InterviewFeedback;
import com.UST.InterviewFeedback.mapper.InterviewFeedbackMapper;
import com.UST.InterviewFeedback.service.InterviewFeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/interview-feedback")
@RestController
public class InterviewFeedbackControllerImpl implements InterviewFeedbackController {
    private final InterviewFeedbackService interviewFeedbackService;
    private final InterviewFeedbackMapper interviewFeedbackMapper;

    public InterviewFeedbackControllerImpl(InterviewFeedbackService interviewFeedbackService, InterviewFeedbackMapper interviewFeedbackMapper) {
        this.interviewFeedbackService = interviewFeedbackService;
        this.interviewFeedbackMapper = interviewFeedbackMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InterviewFeedbackDTO save(@RequestBody InterviewFeedbackDTO interviewFeedbackDTO) {
        InterviewFeedback interviewFeedback = interviewFeedbackMapper.asEntity(interviewFeedbackDTO);
        return interviewFeedbackMapper.asDTO(interviewFeedbackService.save(interviewFeedback));
    }

    @Override
    @GetMapping("/{id}")
    public InterviewFeedbackDTO findById(@PathVariable("id") Long id) {
        InterviewFeedback interviewFeedback = interviewFeedbackService.findById(id).orElse(null);
        return interviewFeedbackMapper.asDTO(interviewFeedback);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        interviewFeedbackService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<InterviewFeedbackDTO> list() {
        return interviewFeedbackMapper.asDTOList(interviewFeedbackService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<InterviewFeedbackDTO> pageQuery(Pageable pageable) {
        Page<InterviewFeedback> interviewFeedbackPage = interviewFeedbackService.findAll(pageable);
        List<InterviewFeedbackDTO> dtoList = interviewFeedbackPage
                .stream()
                .map(interviewFeedbackMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, interviewFeedbackPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public InterviewFeedbackDTO update(@RequestBody InterviewFeedbackDTO interviewFeedbackDTO, @PathVariable("id") Long id) {
        InterviewFeedback interviewFeedback = interviewFeedbackMapper.asEntity(interviewFeedbackDTO);
        return interviewFeedbackMapper.asDTO(interviewFeedbackService.update(interviewFeedback, id));
    }
}