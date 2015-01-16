@echo off

cd %~dp0
cd ..

echo [INFO] release:prepare.
call mvn release:prepare -DautoVersionSubmodules=true

:message
set /p var=1:go on  2:exit  3:rollback:

if "%var%" == "1" (
   goto releasePerform
) else if "%var%" == "2" (
   goto end
) else if "%var%" == "3" (
   goto rollBack
) else (
   goto message
)

:releasePerform
echo [INFO] release perform.
call mvn release:perform -DautoVersionSubmodules=true

:message2
set /p var2=1:go on  2:exit  3:rollback:

if "%var2%" == "1" (
   goto updateTags
) else if "%var2%" == "2" (
   goto end
) else if "%var2%" == "3" (
   goto rollBack
) else (
   goto message2
)

:updateTags
echo [INFO] update tags.
cd ..
cd tags
call svn update

cd %~dp0
goto end

:rollBack
echo [INFO] release rollback.
call mvn release:rollback
goto end

:end
pause 