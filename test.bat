@ECHO OFF
rmdir /s /q class_files
javac *.java -d class_files
cd ./class_files
java Driver
cd ..