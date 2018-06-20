#!/bin/sh

find ua.unit.aircraft/*.java > sources.txt
javac -d . -sourcepath  out/ @sources.txt


