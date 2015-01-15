@echo off
echo [INFO] create a project.

cd %~dp0
cd ..
call mvn deploy -Dmaven.test.skip=true
cd bin
pause