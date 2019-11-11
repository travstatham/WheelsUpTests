#!/bin/bash
mkdir myFiles
cd myFiles
for ((i=1;i<8;i++));
do
	touch file$i.txt
done
ls -t | tail -n+4 | xargs rm