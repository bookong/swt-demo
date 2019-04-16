#!/bin/bash

java -XstartOnFirstThread -Xmx128M -cp %cd% -Djava.ext.dirs="./target:./target/lib" -Djava.library.path="./target/lib" net.bookong.demo.swt.JFaceApplicationWindow