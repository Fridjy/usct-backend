package global.care.usct.controller.dto;

import java.util.Set;

public record CreateCandidateDto(CreatePersonDto person, Set<Integer> packageIds) {}
