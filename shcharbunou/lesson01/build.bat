cls
dir /s /B *.java > sources.txt
javac -d build_calculator @sources.txt
echo Main-Class: calculator.application.Runner > manifest.txt
dir build_calculator /s /B *.class > classes.txt
set path=C:\Users\danie\.jdks\corretto-11.0.13\bin
jar cvfm Calculator.jar manifest.txt @classes.txt
java -jar Calculator.jar