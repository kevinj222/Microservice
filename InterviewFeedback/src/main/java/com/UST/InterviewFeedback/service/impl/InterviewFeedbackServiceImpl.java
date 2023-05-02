package com.UST.InterviewFeedback.service.impl;

import com.UST.InterviewFeedback.dao.InterviewFeedbackRepository;
import com.UST.InterviewFeedback.dto.InterviewFeedbackDTO;
import com.UST.InterviewFeedback.entity.InterviewFeedback;
import com.UST.InterviewFeedback.mapper.InterviewFeedbackMapper;
import com.UST.InterviewFeedback.service.InterviewFeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {
    private final InterviewFeedbackRepository repository;

    public InterviewFeedbackServiceImpl(InterviewFeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public InterviewFeedback save(InterviewFeedback entity) {
        return repository.save(entity);
    }

    @Override
    public List<InterviewFeedback> save(List<InterviewFeedback> entities) {
        return (List<InterviewFeedback>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<InterviewFeedback> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<InterviewFeedback> findAll() {
        return (List<InterviewFeedback>) repository.findAll();
    }

    @Override
    public Page<InterviewFeedback> findAll(Pageable pageable) {
        Page<InterviewFeedback> entityPage = repository.findAll(pageable);
        List<InterviewFeedback> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public InterviewFeedback update(InterviewFeedback entity, Long id) {
        Optional<InterviewFeedback> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}