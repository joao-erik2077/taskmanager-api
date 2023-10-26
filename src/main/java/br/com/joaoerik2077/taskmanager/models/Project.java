package br.com.joaoerik2077.taskmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private LocalDateTime deadline;

	@OneToMany(mappedBy = "project")
	private List<Assignment> assignments;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "teamid")
	private Team team;

	@ManyToMany
	@JoinTable(
			name = "projectsuserslike",
			joinColumns = @JoinColumn(name = "userid"),
			inverseJoinColumns = @JoinColumn(name = "projectid")
	)
	private List<User> users;
}
