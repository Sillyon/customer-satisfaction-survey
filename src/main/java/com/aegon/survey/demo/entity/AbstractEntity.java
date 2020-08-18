package com.aegon.survey.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@Data
public abstract class AbstractEntity implements Entity {
	@Id
	@GeneratedValue(generator = "optimized-sequence")
	@GenericGenerator(
			name = "optimized-sequence", 
			strategy = "enhanced-sequence", 
			parameters = {
					@org.hibernate.annotations.Parameter(name = "prefer_sequence_per_entity", value = "true"),
					@org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo"),
					@org.hibernate.annotations.Parameter(name = "increment_size", value = "1") 
			}
	)
	private Long id;
}
