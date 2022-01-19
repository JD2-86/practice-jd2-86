set path="C:\Program Files\Java\jdk-11.0.12\bin";
cd src/main/java
javac *.java
jar cvfe calculator.jar CalculatorApp *.class
java -jar calculator.jar
