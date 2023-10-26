package br.com.joaoerik2077.taskmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String username;

	@NotNull
	private String password;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<TeamUser> teamUsers;

	@ManyToMany(mappedBy = "users")
	private List<Project> projects;

	@ManyToMany(mappedBy = "users")
	private List<Assignment> assignments;
}
