package br.com.joaoerik2077.taskmanager.models;

import br.com.joaoerik2077.taskmanager.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String description;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private Status status;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "projectid")
	private Project project;

	@ManyToMany
	@JoinTable(
			name = "assignmentsuserslike",
			joinColumns = @JoinColumn(name = "userid"),
			inverseJoinColumns = @JoinColumn(name = "assignmentid")
	)
	private List<User> users;
}
