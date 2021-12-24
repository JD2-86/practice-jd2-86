echo Deleting class files 
rd /s /q out
echo Compiling 
javac -d out/classes -sourcepath src/ src/calculator/CalculatorMain.java
rd /s /q app
mkdir app
copy run.bat app\run.bat
jar -cvfe app/calculator.jar calculator.CalculatorMain -C out/classes .
pause