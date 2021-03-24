package mediator;

import utility.observer.subject.NamedPropertyChangeSubject;

import java.io.IOException;
import java.util.ArrayList;

public interface Model extends NamedPropertyChangeSubject
{
  void addLog(String log) throws IOException;
  boolean verifyLog(String request);
  void addMessage(String message, String user);
  String getList();
  void addUser(String user);
}
