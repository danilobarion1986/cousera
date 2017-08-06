#!/bin/bash
# coursera-algs1-env-setup: Prepare the environment to the course 'Algorithms Part I' on Coursera
# Autor: Danilo Barion Nogueira based on http://algs4.cs.princeton.edu/linux/
set -e

echo "Beginning Setup... If some error occurs, the script will stop! :)"

echo
echo "Installing Java (Oracle)..."
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo apt-get install oracle-java8-set-default 

echo "Creating folder for algs4 jar's..."
cd /usr/local 
sudo mkdir algs4 
sudo chmod 755 algs4 
cd algs4 
pwd 

echo
echo "Downloading and installing algs4 jar's..."
sudo wget http://algs4.cs.princeton.edu/code/algs4.jar 
sudo wget http://algs4.cs.princeton.edu/linux/javac-algs4 
sudo wget http://algs4.cs.princeton.edu/linux/java-algs4 
sudo chmod 755 javac-algs4 java-algs4 
sudo mv javac-algs4 /usr/local/bin 
sudo mv java-algs4 /usr/local/bin

echo 
echo "Downloading and installing DrJava IDE..."
sudo wget http://algs4.cs.princeton.edu/linux/drjava.jar
sudo wget http://algs4.cs.princeton.edu/linux/drjava
sudo wget http://algs4.cs.princeton.edu/linux/.drjava
sudo chmod 755 drjava
sudo mv drjava /usr/local/bin
sudo mv .drjava ~

echo
echo "Downloading and installing algs4 Chechstyle..."
sudo wget http://algs4.cs.princeton.edu/linux/checkstyle.zip
sudo wget http://algs4.cs.princeton.edu/linux/checkstyle-algs4.xml
sudo wget http://algs4.cs.princeton.edu/linux/checkstyle-suppressions.xml
sudo wget http://algs4.cs.princeton.edu/linux/checkstyle-algs4
sudo unzip checkstyle.zip
sudo chmod 755 checkstyle-algs4
sudo mv checkstyle-algs4 /usr/local/bin

echo
echo "Downloading and installing algs4 Findbugs..."
sudo wget http://algs4.cs.princeton.edu/linux/findbugs.zip
sudo wget http://algs4.cs.princeton.edu/linux/findbugs.xml
sudo wget http://algs4.cs.princeton.edu/linux/findbugs-algs4
sudo unzip findbugs.zip
sudo chmod 755 findbugs-algs4
sudo mv findbugs-algs4 /usr/local/bin

echo
echo "Setup completed successfully!"




