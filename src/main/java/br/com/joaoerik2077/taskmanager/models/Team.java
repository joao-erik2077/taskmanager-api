package br.com.joaoerik2077.taskmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@OneToMany(mappedBy = "team")
	private List<TeamUser> teamUsers;

	@OneToMany(mappedBy = "team")
	private List<Project> projects;
}
