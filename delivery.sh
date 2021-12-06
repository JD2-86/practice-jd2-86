#!/bin/sh

rm -rf ./application
mkdir -p ./application
cp run.sh application/start.sh
jar -cvfe  application/calculator.jar task1.CalculatorServiceRunner  -C out/classes .