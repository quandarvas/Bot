javac -classpath src;api\telegram\telegrambots-4.4.0-jar-with-dependencies.jar -d bin -encoding UTF-8 -proc:none src/Main.java
java -classpath bin;api\telegram\telegrambots-4.4.0-jar-with-dependencies.jar Main
pause