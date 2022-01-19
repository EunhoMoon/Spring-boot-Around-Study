package study.spring.AroundHubSpringBoot.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass	// 상속을 위한 Annotation
@EntityListeners(AuditingEntityListener.class)
// Entity가 사용되는 시점에서 이전과 이후에 특정 행동을 해주는 Annotation
public class BaseEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
//	@CreatedBy
//	@Column(updatable = false)
//	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

//	@LastModifiedBy
//	private String updatedBy;
	
}
