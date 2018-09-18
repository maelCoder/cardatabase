package org.fouad.cardatabase.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AccountCredentials {
  private String username;
  private String password;
}