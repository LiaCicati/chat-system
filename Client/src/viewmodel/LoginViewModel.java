package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.io.IOException;

public class LoginViewModel
{
  private Model model;
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;

  public LoginViewModel(Model model)
  {
    this.model = model;
    this.username = new SimpleStringProperty("");
    this.password = new SimpleStringProperty("");
    this.error = new SimpleStringProperty("");
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

  public StringProperty getPasswordProperty()
  {
    return password;
  }

  public StringProperty getUsernameProperty()
  {
    return username;
  }

  public boolean verifyPass(String password, String username) throws IOException
  {
    return model.verifyLog(password, username);
  }

  public void reset() {
    username.set("");
    password.set("");
    error.set("");
  }

}
