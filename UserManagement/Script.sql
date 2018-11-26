--<ScriptOptions statementTerminator=";"/>

CREATE TABLE app.posts (
  user_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
  firstname VARCHAR(50),lastname VARCHAR(50),emailid VARCHAR(50)
  NOT NULL
 );
 
 Select * from app.posts