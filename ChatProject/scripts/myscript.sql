CREATE TABLE app.chatHistory (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(120),
  data VARCHAR(75) NOT NULL
 );