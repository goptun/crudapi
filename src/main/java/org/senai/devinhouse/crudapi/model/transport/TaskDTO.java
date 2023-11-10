package org.senai.devinhouse.crudapi.model.transport;

import java.time.LocalDate;

import org.senai.devinhouse.crudapi.model.Assignee;
import org.senai.devinhouse.crudapi.model.enuns.PriorityEnum;
import org.senai.devinhouse.crudapi.model.enuns.StatusEnum;

public record TaskDTO(Integer id, String description, LocalDate startDate, LocalDate endDate, StatusEnum status,
    PriorityEnum priority,
    Assignee assignee) {

}
