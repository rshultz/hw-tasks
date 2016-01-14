#! /home/rshultz/Downloads/Python-2.7.11/python

import sys
import mmap
import re

found = 0
fileToSearch = file(sys.argv[2])
searchString = sys.argv[1]
fileContents = mmap.mmap(fileToSearch.fileno(), 0, access=mmap.ACCESS_READ)


if re.search(br'(?i)'+searchString, fileContents):
	found = 1

print found
