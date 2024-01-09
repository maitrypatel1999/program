package com.errors;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

  private String message;
  private List<String> details;
}
