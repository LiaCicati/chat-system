package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import viewmodel.LoginViewModel;

import java.io.IOException;

public class LoginViewController extends ViewController
{
  @FXML private TextField username;
  @FXML private PasswordField password;
  @FXML private Label error;
  private LoginViewModel viewModel;

  @Override protected void init()
  {
    viewModel = getViewModelFactory().getLoginViewModel();

  }

  public void reset()
  {
    viewModel.reset();
  }

  public void openChat() throws IOException
  {

    boolean pass = viewModel.verifyPass(password.getText(), username.getText());

    if (password.getText().equals("") || username.getText().equals(""))
    {
      error.setText("The fields can not be empty");
    }
    else if(!pass) {
      error.setText("The password is incorrect");
    }
    else
    {
      error.setText("");
    }
    if (pass)
      getViewHandler().openView(View.CHAT_VIEW);
  }
}
