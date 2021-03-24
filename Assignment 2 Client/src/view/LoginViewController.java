package view;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import viewmodel.LoginViewModel;

import java.io.IOException;

public class LoginViewController extends ViewController
{
  public TextField username;
  public PasswordField password;
  public Label error;
  private LoginViewModel viewModel;

  @Override protected void init()
  {
    viewModel = getViewModelFactory().getLogViewModel();

  }

  public void reset()
  {
  }

  public void openChat() throws IOException
  {

    boolean pass = viewModel.verifyPass(password.getText(), username.getText());
    if (!pass)
    {
      error.setText("Wrong password");
    }
    else if (password.getText().equals(""))
    {
      error.setText("Insert Password");
    }
    else
    {
      error.setText("");
    }
    if (pass)
      getViewHandler().openView(View.CHAT_VIEW);
  }
}
