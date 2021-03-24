package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message
{

  private String messageBody;
  private LocalDateTime dateTime;
  private String user;

  public Message(String message, String user)
  {
    this.messageBody = message;
    this.user = user;
  }


  public String getBody()
  {
    return messageBody;
  }

  public String getUser()
  {
    return user;
  }

  public LocalDateTime getDateTime()
  {
    return dateTime;
  }

  public String getDateTime(String format)
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return dateTime.format(formatter);
  }

  public String toString()
  {
    DateTimeFormatter formatter = DateTimeFormatter
        .ofPattern("d/MM/yyyy HH:mm:ss");
    return "Time=" + dateTime.format(formatter) + ", message=\""
        + messageBody + "\"";
  }
}