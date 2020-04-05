"%JAVA_HOME%\bin\javac.exe" SimpleGUI.java
"%JAVA_HOME%\bin\jar.exe" cfm SimpleGUI.jar MANIFEST.MF *.class icons\*.* *.txt *.html
del *.class
pause
