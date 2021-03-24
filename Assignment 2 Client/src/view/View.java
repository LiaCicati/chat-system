package view;

public enum View
{
  LOGIN_VIEW("LoginView.fxml"),
  CHAT_VIEW("ChatView.fxml");

  private String fxmlFile;

  View(String fxmlFile)
  {
    this.fxmlFile = fxmlFile;
  }

  public String getFxmlFile()
  {
    return fxmlFile;
  }
}
