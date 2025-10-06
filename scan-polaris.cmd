@echo off
set BRIDGE_INSTALL_DIR=C:\Products\br\tc
set BRIDGE_CLI=%BRIDGE_INSTALL_DIR%\bridge-cli.exe

::set BRIDGE_UPDATE=--update
set BRIDGE_UPDATE=

%BRIDGE_CLI% --stage polaris %BRIDGE_UPDATE% ^
  polaris.serverurl=https://poc.polaris.blackduck.com ^
  polaris.application.name=MKM-Demo-Organization ^
  polaris.project.name=MKM-InsecureBank ^
  polaris.branch.name=master-cli ^
  polaris.assessment.types=SCA,SAST ^
  polaris.test.sca.type=SCA-SIGNATURE ^
  detect.search.depth=10 ^
  polaris.reports.sarif.create=false ^
  polaris.reports.sarif.file.path=results.sarif.json

