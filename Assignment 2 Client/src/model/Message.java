package model;

public class Message
{
  private String messageBody;
  private String user;

  public Message( String message, String user)
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

  public String toString()
  {
    return  ", message=\"" + messageBody + "\"";
  }
}