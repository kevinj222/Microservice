package com.UST.InterviewFeedback.mapper;

import com.UST.InterviewFeedback.dto.InterviewFeedbackDTO;
import com.UST.InterviewFeedback.entity.InterviewFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InterviewFeedbackMapper extends GenericMapper<InterviewFeedback, InterviewFeedbackDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    InterviewFeedback asEntity(InterviewFeedbackDTO dto);
}