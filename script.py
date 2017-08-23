import json
from pprint import pprint
import pip
fail=[]
with open('data.json') as data_file:
	data= json.load(data_file)
	
length= len(data["Dependencies"])
print length
pprint (data)
c=1
fail_count=0
while (c<=length):
  	pac=data["Dependencies"][c-1]
  	val=pip.main(['install', '--no-dependencies', pac])
  	print val
  	if val != 0:
  		fail_count=fail_count + 1
  		fail.append(data["Dependencies"][c-1])
  	c=c+1

if fail_count > 0:
	print "The following packages failed to install:"
	for x in fail:
		print x
else:
	print "Succesfully installed all packages"