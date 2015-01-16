@echo off
echo [INFO] Create war package file.

cd %~dp0
cd ..
call mvn clean
call mvn package -Dmaven.test.skip=true
cd bin
pause