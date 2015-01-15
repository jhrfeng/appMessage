@echo off
echo [INFO] create maven site.

cd %~dp0
cd ..
call mvn site -Dmaven.test.skip=true

:message
set /p var=deploy site?y/n:

if "%var%" == "y" (
   call mvn site:deploy
) else if "%var%" == "n" (
   goto end
) else (
   goto message
)

:end
cd %~dp0
pause