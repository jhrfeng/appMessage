
@echo off
echo [INFO] create project to myeclipse

cd %~dp0
cd ..
call mvn eclipse:myeclipse -Dwtpversion=1.0
cd bin
pause
