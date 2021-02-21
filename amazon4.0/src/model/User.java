package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="User")
public class User {
	private String name;
}
