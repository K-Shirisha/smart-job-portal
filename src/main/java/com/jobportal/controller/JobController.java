package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // CREATE
    @PostMapping
    public Job createJob(@Valid @RequestBody Job job){
        return jobService.saveJob(job);
    }

    // READ ALL
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,
                         @Valid @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "Job Deleted Successfully";
    }
}