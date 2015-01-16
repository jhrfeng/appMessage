@echo off

echo [INFO] create project from current project archetype.

cd %~dp0
cd ..

if not exist generated-sources (md generated-sources)

cd generated-sources
call mvn archetype:generate -DarchetypeGroupId=org.ispring.mis -DarchetypeArtifactId=mis-archetype -DarchetypeVersion=1.0.0

cd %~dp0
pause