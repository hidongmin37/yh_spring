package study.data_jpa.repsitory;

import lombok.Getter;

@Getter
public class UsernameOnlyDto {

	private final String username;

	public UsernameOnlyDto(String username) {
		this.username = username;
	}

}
