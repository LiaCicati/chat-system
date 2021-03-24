package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewmodel.ChatViewModel;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ChatViewController extends ViewController
{
  public ListView<String> list;
  public TextField text;
  private ChatViewModel viewModel;

  @Override protected void init()
  {
    viewModel = getViewModelFactory().getChatViewModel();
    list.setItems(viewModel.getLogs());

  }

  public void reset()
  {
  }

  @FXML public void setText() throws IOException
  {
    if (!text.getText().equals(""))
    {
      viewModel.setMessage(text.getText());
      text.setText("");
    }
  }
}
