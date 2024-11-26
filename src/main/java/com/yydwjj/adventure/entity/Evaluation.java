package com.yydwjj.adventure.entity;


public class Evaluation {

  private long evaluationId;
  private long evaluatorId;
  private long evaluateeId;
  private long jobId;
  private String content;
  private long rating;
  private java.sql.Timestamp evaluationTime;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;


  public long getEvaluationId() {
    return evaluationId;
  }

  public void setEvaluationId(long evaluationId) {
    this.evaluationId = evaluationId;
  }


  public long getEvaluatorId() {
    return evaluatorId;
  }

  public void setEvaluatorId(long evaluatorId) {
    this.evaluatorId = evaluatorId;
  }


  public long getEvaluateeId() {
    return evaluateeId;
  }

  public void setEvaluateeId(long evaluateeId) {
    this.evaluateeId = evaluateeId;
  }


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getRating() {
    return rating;
  }

  public void setRating(long rating) {
    this.rating = rating;
  }


  public java.sql.Timestamp getEvaluationTime() {
    return evaluationTime;
  }

  public void setEvaluationTime(java.sql.Timestamp evaluationTime) {
    this.evaluationTime = evaluationTime;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }

}
