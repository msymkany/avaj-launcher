#!/bin/sh

find aircraft/*.java > sources.txt
javac -d . -sourcepath  aircraft/ @sources.txt


