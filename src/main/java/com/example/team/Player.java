package com.example.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="player")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

	@Id
	@GeneratedValue
	Long id;
	String name;
	String position;


}
