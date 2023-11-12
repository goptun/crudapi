package org.senai.devinhouse.crudapi.controller;

import java.util.List;

import org.senai.devinhouse.crudapi.database.Database;
import org.senai.devinhouse.crudapi.model.Task;
import org.senai.devinhouse.crudapi.model.transport.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

  @PostMapping
  public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
    Task task = new Task(taskDTO);
    Database.add(task);
    return ResponseEntity.status(HttpStatus.CREATED).body(taskDTO);
  }

  @GetMapping
  public ResponseEntity<List<TaskDTO>> list() {
    List<Task> tasks = Database.listAll();
    List<TaskDTO> response = tasks.stream().map(task -> new TaskDTO(task)).toList();

    return ResponseEntity.ok(response);
  }
}
