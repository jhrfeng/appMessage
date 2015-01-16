@echo off
echo [INFO] auto create svn branch.

cd %~dp0
cd ..

:message
set /p command=please input branchName:

if not defined command (
	goto message
) else (
	call mvn release:branch -DbranchName=%command% -DupdateBranchVersions=true -DupdateWorkingCopyVersions=false
)

cd ..
cd branches
call svn update

cd %~dp0
pause