@echo off
echo [INFO] create a archetype from current project.

set base_path=%cd%

cd %~dp0
cd ..

call mvn clean archetype:create-from-project

:message
set /p var=install to local repo?y/n:

if "%var%" == "y" (
   goto install
) else if "%var%" == "n" (
   goto end
) else (
   goto message
)

:install
echo [INFO] install to local repo.
cd target\generated-sources\archetype
call mvn install -Dmaven.test.skip=true
goto end

:end
cd %base_path%
pause