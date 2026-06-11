package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;
import com.jobportal.exception.JobNotFoundException;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // CREATE
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // READ ALL
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // READ BY ID
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException(
                                "Job not found with id : " + id));
    }

    // UPDATE
    public Job updateJob(Long id, Job updatedJob) {

        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob != null) {

            existingJob.setTitle(updatedJob.getTitle());
            existingJob.setCompany(updatedJob.getCompany());
            existingJob.setLocation(updatedJob.getLocation());
            existingJob.setSalary(updatedJob.getSalary());
            existingJob.setDescription(updatedJob.getDescription());

            return jobRepository.save(existingJob);
        }

        return null;
    }

    // DELETE
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}