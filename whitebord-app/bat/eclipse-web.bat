@echo off
echo [INFO] create a project.

cd %~dp0
cd ..
call mvn eclipse:eclipse -Dwtpversion=1.0
cd bin
pause