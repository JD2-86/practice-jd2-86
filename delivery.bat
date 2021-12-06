rd /s /q ".\application"
mkdir .\application
copy run.bat application\start.bat
jar -cvfe  application/calculator.jar task1.CalculatorServiceRunner  -C out/classes .
