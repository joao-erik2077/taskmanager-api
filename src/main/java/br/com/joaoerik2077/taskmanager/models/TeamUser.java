package br.com.joaoerik2077.taskmanager.models;

import br.com.joaoerik2077.taskmanager.enums.Permissions;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class TeamUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private Permissions permissions;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "teamid")
	private Team team;
}
