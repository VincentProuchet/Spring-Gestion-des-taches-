package com.gdt.dto;

public class UserTaskDTO {
	private Long userId;
	private Long taskId;

	public UserTaskDTO() {
		super();
	}

	public UserTaskDTO(Long userId, Long taskId) {
		super();
		this.userId = userId;
		this.taskId = taskId;
	}

	/**
	 * Getter
	 * 
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Getter
	 * 
	 * @return the taskId
	 */
	public Long getTaskId() {
		return taskId;
	}

	/**
	 * Setter
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Setter
	 * 
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

}
